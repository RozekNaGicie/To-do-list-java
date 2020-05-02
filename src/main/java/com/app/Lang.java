package com.app;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table( name = "languages" )
class Lang {
    @Id
    @GeneratedValue(generator="inc")
    @GenericGenerator(name="inc", strategy = "increment")
    private Integer id;
    private String welcomeMsg;
    private String code;

    /**
     * Hibernete needs it.
     */
    @SuppressWarnings("unused")
    Lang(){
    }

    public Lang(Integer id, String welcomeMsg, String code) {
        this.id = id;
        this.welcomeMsg = welcomeMsg;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public String getWelcomeMsg() {
        return welcomeMsg;
    }

    public void setWelcomeMsg(String welcomeMsg) {
        this.welcomeMsg = welcomeMsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lang lang = (Lang) o;
        return id == lang.id &&
                Objects.equals(welcomeMsg, lang.welcomeMsg) &&
                Objects.equals(code, lang.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, welcomeMsg, code);
    }
}
