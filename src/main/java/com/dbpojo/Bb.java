/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbpojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ismailu
 */
@Entity
@Table(name = "bb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bb.findAll", query = "SELECT b FROM Bb b")
    , @NamedQuery(name = "Bb.findById", query = "SELECT b FROM Bb b WHERE b.id = :id")
    , @NamedQuery(name = "Bb.findByTaka", query = "SELECT b FROM Bb b WHERE b.taka = :taka")
    , @NamedQuery(name = "Bb.findByR", query = "SELECT b FROM Bb b WHERE b.r = :r")})
public class Bb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "taka")
    private Integer taka;
    @Column(name = "r")
    private Integer r;

    public Bb() {
    }

    public Bb(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaka() {
        return taka;
    }

    public void setTaka(Integer taka) {
        this.taka = taka;
    }

    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bb)) {
            return false;
        }
        Bb other = (Bb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbpojo.Bb[ id=" + id + " ]";
    }

}
