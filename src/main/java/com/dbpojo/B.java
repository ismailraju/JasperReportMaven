/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbpojo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ismailu
 */
@Entity
@Table(name = "b")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "B.findAll", query = "SELECT b FROM B b")
    , @NamedQuery(name = "B.findById", query = "SELECT b FROM B b WHERE b.id = :id")
    , @NamedQuery(name = "B.findByName", query = "SELECT b FROM B b WHERE b.name = :name")
    , @NamedQuery(name = "B.findByRole", query = "SELECT b FROM B b WHERE b.role = :role")
    , @NamedQuery(name = "B.findByTaka", query = "SELECT b FROM B b WHERE b.taka = :taka")
    , @NamedQuery(name = "B.findByTime", query = "SELECT b FROM B b WHERE b.time = :time")
    , @NamedQuery(name = "B.findByTimestamp", query = "SELECT b FROM B b WHERE b.timestamp = :timestamp")
    , @NamedQuery(name = "B.findByR", query = "SELECT b FROM B b WHERE b.r = :r")})
public class B implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "role")
    private String role;
    @Column(name = "taka")
    private BigInteger taka;
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Basic(optional = false)
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @Column(name = "r")
    private Integer r;

    public B() {
    }

    public B(Integer id) {
        this.id = id;
    }

    public B(Integer id, Date timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public BigInteger getTaka() {
        return taka;
    }

    public void setTaka(BigInteger taka) {
        this.taka = taka;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
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
        if (!(object instanceof B)) {
            return false;
        }
        B other = (B) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbpojo.B[ id=" + id + " ]";
    }

}
