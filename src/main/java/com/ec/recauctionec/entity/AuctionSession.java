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
@Table(name = "auction_session", schema = "recauction_db", catalog = "")
public class AuctionSession {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "auction_sess_id", nullable = false)
    private int auctionSessId;
    @Basic
    @Column(name = "closing_price", nullable = true, precision = 0)
    private Double closingPrice;
    @Basic
    @Column(name = "createDate", nullable = false)
    private Timestamp createDate;
    @Basic
    @Column(name = "end_date", nullable = false)
    private Timestamp endDate;
    @Basic
    @Column(name = "isComplete", nullable = false)
    private boolean isComplete;
    @Basic
    @Column(name = "product_key", nullable = false, length = 255)
    private String productKey;
    @Basic
    @Column(name = "category_id", nullable = false)
    private int categoryId;
    @Basic
    @Column(name = "reserve_price", nullable = false, precision = 0)
    private double reservePrice;
    @Basic
    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;
    @Basic
    @Column(name = "description", length = 255)
    private String description;
    @Basic
    @Column(name = "user_id", nullable = false)
    private int userId;
    @Basic
    @Column(name = "product_tag_str", nullable = true, length = 255)
    private String productTagStr;
    @OneToMany(mappedBy = "auctionSessionByAuctionSessId",fetch = FetchType.LAZY)
    private Collection<AuctSessJoin> auctSessJoinsByAuctionSessId;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false,
            insertable = false, updatable = false)
    private Category categoryByCategoryId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false,
            insertable = false, updatable = false)
    private User userByUserId;

    @OneToMany(mappedBy = "auction", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<AuctionImg> img;


}
