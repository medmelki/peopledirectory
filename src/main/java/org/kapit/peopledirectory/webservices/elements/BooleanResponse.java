package org.kapit.peopledirectory.webservices.elements;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BooleanResponse {

    private boolean value = false;

    @XmlElement
    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

}
