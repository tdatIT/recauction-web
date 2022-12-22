package com.ec.recauctionec.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@EqualsAndHashCode

@Table(name = "auct_sess_join", schema = "recauction_db", catalog = "")
public class AuctSessJoin {

    public static final int NOT_CONFIRM = 1;
    public static final int ACTIVE = 2;
    public static final int LOSS = 3;
    public static final int WIN = 4;
    public static final int CANCEL = 0;

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

    @OneToOne(mappedBy = "winAuction",fetch = FetchType.LAZY)
    private Orders orders;

}
