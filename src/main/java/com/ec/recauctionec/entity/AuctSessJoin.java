package com.ec.recauctionec.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Getter
@Setter
@EqualsAndHashCode

@Table(name = "auct_sess_join", schema = "recauction_db", catalog = "")
public class AuctSessJoin {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "product_id", nullable = false)
    private int productId;
    @Basic
    @Column(name = "auction_sess_id", nullable = false)
    private int auctionSessId;
    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    private double price;
    @Basic
    @Column(name = "status", nullable = false)
    private int status;
    @Basic
    @Column(name = "time", nullable = false)
    private Timestamp time;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false,
            insertable = false, updatable = false)
    private Product productByProductId;
    @ManyToOne
    @JoinColumn(name = "auction_sess_id", referencedColumnName = "auction_sess_id", nullable = false,
            insertable = false, updatable = false)
    private AuctionSession auctionSessionByAuctionSessId;
    @OneToMany(mappedBy = "auctSessJoinByAucWinId")
    private Collection<Orders> ordersById;


}
