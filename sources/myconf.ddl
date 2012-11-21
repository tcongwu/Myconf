
    alter table Myconf_PaperAuthor 
        drop 
        foreign key FK574FD748D4BDFCA4;

    alter table Myconf_PaperInfo 
        drop 
        foreign key FKE71065ABC1D6F608;

    alter table Myconf_PaperInfo 
        drop 
        foreign key FKE71065AB3F65E8D4;

    alter table Myconf_PaperInfo 
        drop 
        foreign key FKE71065AB737DF280;

    alter table Myconf_PaperInfo 
        drop 
        foreign key FKE71065AB6584F589;

    alter table Myconf_ReviewBid 
        drop 
        foreign key FKF2B3CFD6D4BDFCA4;

    alter table Myconf_ReviewPaper 
        drop 
        foreign key FK15C11225D4BDFCA4;

    alter table Myconf_ReviewWords 
        drop 
        foreign key FK162A1B42D4BDFCA4;

    alter table Myconf_SiteContent 
        drop 
        foreign key FKA1329043552B2EEB;

    alter table Myconf_SiteMenu 
        drop 
        foreign key FKDC885DD5552B2EEB;

    drop table if exists Myconf_BBSInfo;

    drop table if exists Myconf_PaperAuthor;

    drop table if exists Myconf_PaperInfo;

    drop table if exists Myconf_PaperStatus;

    drop table if exists Myconf_PaperSubject;

    drop table if exists Myconf_ReviewBid;

    drop table if exists Myconf_ReviewPaper;

    drop table if exists Myconf_ReviewRefer;

    drop table if exists Myconf_ReviewWords;

    drop table if exists Myconf_SiteContent;

    drop table if exists Myconf_SiteLang;

    drop table if exists Myconf_SiteMenu;

    drop table if exists Myconf_StatInfo;

    drop table if exists Myconf_SysConfig;

    drop table if exists Myconf_UserInfo;

    create table Myconf_BBSInfo (
        id integer not null auto_increment,
        boardname varchar(50) not null unique,
        parentid integer,
        title varchar(100),
        content text,
        istop integer,
        astatus integer,
        authorid integer,
        authorname varchar(90),
        visitcount integer,
        replycount integer,
        createtime datetime default null,
        primary key (id)
    );

    create table Myconf_PaperAuthor (
        id integer not null auto_increment,
        paperid integer,
        orderno integer not null,
        firstname varchar(45) not null,
        lastname varchar(45) not null,
        email varchar(50),
        institute varchar(255),
        regtime datetime default null,
        updatetime datetime default null,
        primary key (id)
    );

    create table Myconf_PaperInfo (
        id integer not null auto_increment,
        userid integer,
        title varchar(255) not null,
        state integer not null,
        abstract text,
        filepath varchar(50),
        asubject integer,
        astatus integer,
        score float,
        regtime datetime default null,
        updatetime datetime default null,
        subject integer,
        primary key (id)
    );

    create table Myconf_PaperStatus (
        id integer not null auto_increment,
        astatus varchar(45),
        regtime datetime default null,
        updatetime datetime default null,
        primary key (id)
    );

    create table Myconf_PaperSubject (
        id integer not null auto_increment,
        subject varchar(255),
        regtime datetime default null,
        updatetime datetime default null,
        primary key (id)
    );

    create table Myconf_ReviewBid (
        id integer not null auto_increment,
        paperid integer,
        expertid integer not null,
        expertname varchar(90) not null,
        research varchar(100),
        bidtime datetime default null,
        primary key (id)
    );

    create table Myconf_ReviewPaper (
        id integer not null auto_increment,
        paperid integer,
        expertid integer not null,
        expertname varchar(90) not null,
        gstatus integer not null,
        score1 float,
        score2 float,
        score3 float,
        score4 float,
        score5 float,
        score6 float,
        score7 float,
        score8 float,
        score9 float,
        score10 float,
        score11 float,
        score12 float,
        score13 float,
        score14 float,
        score15 float,
        score16 float,
        totalscore float,
        recostatus integer,
        opinion text,
        reviewtime datetime default null,
        primary key (id)
    );

    create table Myconf_ReviewRefer (
        id integer not null auto_increment,
        referno integer not null unique,
        rstatus integer,
        title varchar(255) not null,
        minscore float,
        maxscore float not null,
        description text,
        primary key (id)
    );

    create table Myconf_ReviewWords (
        id integer not null auto_increment,
        paperid integer,
        userid integer not null,
        firstname varchar(45) not null,
        lastname varchar(45) not null,
        content text,
        createtime datetime default null,
        primary key (id)
    );

    create table Myconf_SiteContent (
        id integer not null auto_increment,
        lang integer,
        title varchar(255) not null unique,
        pagetext text not null,
        sectionid integer,
        version integer,
        published integer,
        ordering integer,
        hits integer,
        creator integer,
        createtime datetime default null,
        modifier integer,
        modifytime datetime default null,
        primary key (id)
    );

    create table Myconf_SiteLang (
        id integer not null,
        languange varchar(45) not null,
        confname varchar(255),
        shortname varchar(45),
        template varchar(45),
        copyright varchar(255),
        email varchar(50),
        published integer,
        isdefault integer,
        createtime datetime default null,
        updatetime datetime default null,
        primary key (id)
    );

    create table Myconf_SiteMenu (
        id integer not null auto_increment,
        lang integer,
        menutype varchar(10),
        menuname varchar(100) not null unique,
        link varchar(255) not null,
        type varchar(10) not null,
        opentype varchar(20),
        style varchar(50),
        published integer,
        ordering integer,
        creator integer,
        createtime datetime default null,
        modifier integer,
        modifytime datetime default null,
        primary key (id)
    );

    create table Myconf_StatInfo (
        id integer not null auto_increment,
        statdate integer,
        uvcount integer,
        pvcount integer,
        updatetime datetime default null,
        primary key (id)
    );

    create table Myconf_SysConfig (
        id integer not null,
        banner varchar(255),
        subins text,
        subformat varchar(255),
        subsize integer,
        subbegindate bigint,
        subendDate bigint,
        conbegindate bigint,
        conendDate bigint,
        reviewins text,
        reviewbegindate bigint,
        reviewendDate bigint,
        isprocess integer,
        isopen integer,
        updatetime datetime default null,
        primary key (id)
    );

    create table Myconf_UserInfo (
        id integer not null auto_increment,
        email varchar(50) not null unique,
        password varchar(50) not null,
        title varchar(10),
        firstname varchar(45),
        lastname varchar(45),
        worklocation varchar(100),
        research varchar(100),
        phone varchar(28),
        fax varchar(28),
        address varchar(255),
        postcode varchar(12),
        state varchar(20),
        country varchar(20),
        isadmin integer,
        isexpert integer,
        iscontent integer,
        isauthor integer,
        urole varchar(8),
        ustatus integer,
        isonline integer,
        logincount integer,
        regtime datetime default null,
        lasttime datetime default null,
        lastaddr varchar(45),
        primary key (id)
    );

    create index bbs_parentid_idx on Myconf_BBSInfo (parentid);

    create index bbs_istop_idx on Myconf_BBSInfo (istop);

    alter table Myconf_PaperAuthor 
        add index FK574FD748D4BDFCA4 (paperid), 
        add constraint FK574FD748D4BDFCA4 
        foreign key (paperid) 
        references Myconf_PaperInfo (id);

    create index paper_score_idx on Myconf_PaperInfo (score);

    create index paper_status_idx on Myconf_PaperInfo (astatus);

    create index paper_suject_idx on Myconf_PaperInfo (asubject);

    create index paper_title_idx on Myconf_PaperInfo (title);

    create index paper_state_idx on Myconf_PaperInfo (state);

    alter table Myconf_PaperInfo 
        add index FKE71065ABC1D6F608 (asubject), 
        add constraint FKE71065ABC1D6F608 
        foreign key (asubject) 
        references Myconf_PaperSubject (id);

    alter table Myconf_PaperInfo 
        add index FKE71065AB3F65E8D4 (astatus), 
        add constraint FKE71065AB3F65E8D4 
        foreign key (astatus) 
        references Myconf_PaperStatus (id);

    alter table Myconf_PaperInfo 
        add index FKE71065AB737DF280 (userid), 
        add constraint FKE71065AB737DF280 
        foreign key (userid) 
        references Myconf_UserInfo (id);

    alter table Myconf_PaperInfo 
        add index FKE71065AB6584F589 (subject), 
        add constraint FKE71065AB6584F589 
        foreign key (subject) 
        references Myconf_PaperSubject (id);

    alter table Myconf_ReviewBid 
        add index FKF2B3CFD6D4BDFCA4 (paperid), 
        add constraint FKF2B3CFD6D4BDFCA4 
        foreign key (paperid) 
        references Myconf_PaperInfo (id);

    create index review_status_idx on Myconf_ReviewPaper (gstatus);

    create index review_recostatus_idx on Myconf_ReviewPaper (recostatus);

    create index review_totalscore_idx on Myconf_ReviewPaper (totalscore);

    alter table Myconf_ReviewPaper 
        add index FK15C11225D4BDFCA4 (paperid), 
        add constraint FK15C11225D4BDFCA4 
        foreign key (paperid) 
        references Myconf_PaperInfo (id);

    alter table Myconf_ReviewWords 
        add index FK162A1B42D4BDFCA4 (paperid), 
        add constraint FK162A1B42D4BDFCA4 
        foreign key (paperid) 
        references Myconf_PaperInfo (id);

    alter table Myconf_SiteContent 
        add index FKA1329043552B2EEB (lang), 
        add constraint FKA1329043552B2EEB 
        foreign key (lang) 
        references Myconf_SiteLang (id);

    create index site_language_idx on Myconf_SiteLang (languange);

    alter table Myconf_SiteMenu 
        add index FKDC885DD5552B2EEB (lang), 
        add constraint FKDC885DD5552B2EEB 
        foreign key (lang) 
        references Myconf_SiteLang (id);

    create index stat_date_idx on Myconf_StatInfo (statdate);

    create index userinfo_country_idx on Myconf_UserInfo (country);

    create index userinfo_online_idx on Myconf_UserInfo (isonline);

    create index userinfo_expert_idx on Myconf_UserInfo (isexpert);
