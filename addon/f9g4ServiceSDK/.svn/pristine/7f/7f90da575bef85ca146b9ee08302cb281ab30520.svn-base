package com.f9g4.test.servicesdk.helper;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class JaxbMapper {

    private Collection<String> packageList = new ArrayList<String>();
    private JAXBContext jaxbContext;

    public void addPackageList(Collection<String> packages) {
        this.packageList.addAll(packages);
        jaxbContext = null;
    }

    public void addPackage(String pkg) {
        addPackageList(Arrays.asList(pkg));
    }

    public void addPackageForClass(Class<? extends Object> clazz) {
        addPackage(clazz.getPackage().getName());
    }

    public Object unmarshal(String string) throws JAXBException {
        Unmarshaller unmarshaller = getJaxbContext().createUnmarshaller();

        return unmarshaller.unmarshal(new StringReader(string.trim()));
    }

    private synchronized JAXBContext getJaxbContext() throws JAXBException {
        if (jaxbContext == null) {
            jaxbContext = JAXBContext.newInstance(getPackageNamesAsListSeparatedByColon());
        }
        return jaxbContext;
    }

    private String getPackageNamesAsListSeparatedByColon() {
        StringBuffer buffer = new StringBuffer();
        for (String packageName : packageList) {
            if (buffer.length() > 0) {
                buffer.append(":");
            }
            buffer.append(packageName);
        }
        return buffer.toString();
    }

}