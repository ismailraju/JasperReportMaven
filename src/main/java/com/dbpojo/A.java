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
@Table(name = "a")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "A.findAll", query = "SELECT a FROM A a")
    , @NamedQuery(name = "A.findById", query = "SELECT a FROM A a WHERE a.id = :id")
    , @NamedQuery(name = "A.findByName", query = "SELECT a FROM A a WHERE a.name = :name")
    , @NamedQuery(name = "A.findByRole", query = "SELECT a FROM A a WHERE a.role = :role")
    , @NamedQuery(name = "A.findByTaka", query = "SELECT a FROM A a WHERE a.taka = :taka")
    , @NamedQuery(name = "A.findByTime", query = "SELECT a FROM A a WHERE a.time = :time")
    , @NamedQuery(name = "A.findByTimestamp", query = "SELECT a FROM A a WHERE a.timestamp = :timestamp")
    , @NamedQuery(name = "A.findByR", query = "SELECT a FROM A a WHERE a.r = :r")})
public class A implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
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

    public A() {
    }

    public A(Integer id) {
        this.id = id;
    }

    public A(Integer id, Date timestamp) {
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
        if (!(object instanceof A)) {
            return false;
        }
        A other = (A) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbpojo.A[ id=" + id + " ]";
    }

}
