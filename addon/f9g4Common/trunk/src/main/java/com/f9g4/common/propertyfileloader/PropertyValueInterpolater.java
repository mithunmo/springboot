package com.f9g4.common.propertyfileloader;

import java.util.Iterator;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is responsible for interpolating values in properties files contained wrapped with ${} and replacing it
 * with existing system property value or property value within properties being processed.
 */
public class PropertyValueInterpolater {

    /**
     * matches a string prefixed with "${" and ending with "}" with any char except a "$" in the middle. The value
     * wrapped is captured in backreference 1.
     */
    private static Pattern regex = Pattern.compile("\\$\\{([^$]+)\\}", Pattern.CANON_EQ);

    private final Properties newProperties;

    public PropertyValueInterpolater(Properties properties) {
        newProperties = new Properties();
        for (Iterator<Object> i = properties.keySet().iterator(); i.hasNext();) {
            String key = (String) i.next();
            newProperties.setProperty(key, properties.getProperty(key));
        }
    }

    public Properties interpolate() {
        boolean foundAny = true;
        while (foundAny) {
            foundAny = lookForValuesToInterpolate();
        }
        return newProperties;
    }

    private boolean lookForValuesToInterpolate() {
        boolean foundAny = false;
        
        for (Object key : newProperties.keySet()) {
			Object value = newProperties.get(key);
			Matcher matcher = regex.matcher((CharSequence) value);
            if (matcher.find()) {
                String keyToInterpol = matcher.group(1);
                String valueToInterpol = System.getProperty(keyToInterpol);
                if (valueToInterpol == null) {
                    valueToInterpol = newProperties.getProperty(keyToInterpol);
                }
                if (valueToInterpol != null) {
                    // I'm never sure if this is the right thing to do. It could be intentional that there is a space.
                    // On the other hand, I've had to debug a problem caused by this.
                    valueToInterpol = valueToInterpol.trim();
                    valueToInterpol = valueToInterpol.replaceAll("\\$", "\\\\\\$"); // java weirdness, can't have a $
                    String newValue = matcher.replaceFirst(valueToInterpol);
                    newProperties.setProperty((String) key, newValue);
                    foundAny = true;
                }
            }
		}
        
        return foundAny;
    }
}
