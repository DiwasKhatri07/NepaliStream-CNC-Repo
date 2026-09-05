package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TorraStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\bJ\b\u0086\b\u0018\u00002\u00020\u0001Bµ\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010G\u001a\u00020\u0011HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0011HÆ\u0003J\t\u0010O\u001a\u00020\u0011HÆ\u0003J\t\u0010P\u001a\u00020\u0011HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010S\u001a\u00020\u0011HÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u00109J¼\u0002\u0010U\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00112\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00112\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010VJ\u0014\u0010W\u001a\u00020\u00112\b\u0010X\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010Y\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010Z\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b&\u0010\"R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b(\u0010\"R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b)\u0010\"R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b*\u0010\"R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010%R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b.\u0010\"R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010%R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u00100R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b1\u0010\"R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b2\u0010\"R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010%R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010%R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010%R\u0011\u0010\u0018\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u00100R\u0011\u0010\u0019\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u00100R\u0011\u0010\u001a\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u00100R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010%R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u0010%R\u0011\u0010\u001d\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u00100R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010:\u001a\u0004\b\u001e\u00109¨\u0006["}, d2 = {"Lcom/phisher98/LinkData;", "", "id", "", "imdbId", "", "tvdbId", "type", "season", "episode", "epid", "aniId", "animeId", "title", "year", "orgTitle", "isAnime", "", "airedYear", "lastSeason", "epsTitle", "jpTitle", "date", "airedDate", "isAsian", "isBollywood", "isCartoon", "alttitle", "nametitle", "isDub", "isMovie", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImdbId", "()Ljava/lang/String;", "getTvdbId", "getType", "getSeason", "getEpisode", "getEpid", "getAniId", "getAnimeId", "getTitle", "getYear", "getOrgTitle", "()Z", "getAiredYear", "getLastSeason", "getEpsTitle", "getJpTitle", "getDate", "getAiredDate", "getAlttitle", "getNametitle", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;)Lcom/phisher98/LinkData;", "equals", "other", "hashCode", "toString", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class LinkData {

    @Nullable
    private final String airedDate;

    @Nullable
    private final Integer airedYear;

    @Nullable
    private final String alttitle;

    @Nullable
    private final String aniId;

    @Nullable
    private final String animeId;

    @Nullable
    private final String date;

    @Nullable
    private final Integer epid;

    @Nullable
    private final Integer episode;

    @Nullable
    private final String epsTitle;

    @Nullable
    private final Integer id;

    @Nullable
    private final String imdbId;
    private final boolean isAnime;
    private final boolean isAsian;
    private final boolean isBollywood;
    private final boolean isCartoon;
    private final boolean isDub;

    @Nullable
    private final Boolean isMovie;

    @Nullable
    private final String jpTitle;

    @Nullable
    private final Integer lastSeason;

    @Nullable
    private final String nametitle;

    @Nullable
    private final String orgTitle;

    @Nullable
    private final Integer season;

    @Nullable
    private final String title;

    @Nullable
    private final Integer tvdbId;

    @Nullable
    private final String type;

    @Nullable
    private final Integer year;

    public LinkData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, false, false, false, null, null, false, null, 67108863, null);
    }

    public static /* synthetic */ LinkData copy$default(LinkData linkData, Integer num, String str, Integer num2, String str2, Integer num3, Integer num4, Integer num5, String str3, String str4, String str5, Integer num6, String str6, boolean z, Integer num7, Integer num8, String str7, String str8, String str9, String str10, boolean z2, boolean z3, boolean z4, String str11, String str12, boolean z5, Boolean bool, int i, Object obj) {
        Boolean bool2;
        boolean z6;
        Integer num9 = (i & 1) != 0 ? linkData.id : num;
        String str13 = (i & 2) != 0 ? linkData.imdbId : str;
        Integer num10 = (i & 4) != 0 ? linkData.tvdbId : num2;
        String str14 = (i & 8) != 0 ? linkData.type : str2;
        Integer num11 = (i & 16) != 0 ? linkData.season : num3;
        Integer num12 = (i & 32) != 0 ? linkData.episode : num4;
        Integer num13 = (i & 64) != 0 ? linkData.epid : num5;
        String str15 = (i & 128) != 0 ? linkData.aniId : str3;
        String str16 = (i & 256) != 0 ? linkData.animeId : str4;
        String str17 = (i & 512) != 0 ? linkData.title : str5;
        Integer num14 = (i & 1024) != 0 ? linkData.year : num6;
        String str18 = (i & 2048) != 0 ? linkData.orgTitle : str6;
        boolean z7 = (i & 4096) != 0 ? linkData.isAnime : z;
        Integer num15 = (i & 8192) != 0 ? linkData.airedYear : num7;
        Integer num16 = num9;
        Integer num17 = (i & 16384) != 0 ? linkData.lastSeason : num8;
        String str19 = (i & 32768) != 0 ? linkData.epsTitle : str7;
        String str20 = (i & 65536) != 0 ? linkData.jpTitle : str8;
        String str21 = (i & 131072) != 0 ? linkData.date : str9;
        String str22 = (i & 262144) != 0 ? linkData.airedDate : str10;
        boolean z8 = (i & 524288) != 0 ? linkData.isAsian : z2;
        boolean z9 = (i & 1048576) != 0 ? linkData.isBollywood : z3;
        boolean z10 = (i & 2097152) != 0 ? linkData.isCartoon : z4;
        String str23 = (i & 4194304) != 0 ? linkData.alttitle : str11;
        String str24 = (i & 8388608) != 0 ? linkData.nametitle : str12;
        boolean z11 = (i & 16777216) != 0 ? linkData.isDub : z5;
        if ((i & 33554432) != 0) {
            z6 = z11;
            bool2 = linkData.isMovie;
        } else {
            bool2 = bool;
            z6 = z11;
        }
        return linkData.copy(num16, str13, num10, str14, num11, num12, num13, str15, str16, str17, num14, str18, z7, num15, num17, str19, str20, str21, str22, z8, z9, z10, str23, str24, z6, bool2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Integer getYear() {
        return this.year;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getOrgTitle() {
        return this.orgTitle;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getIsAnime() {
        return this.isAnime;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Integer getAiredYear() {
        return this.airedYear;
    }

    @Nullable
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Integer getLastSeason() {
        return this.lastSeason;
    }

    @Nullable
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getEpsTitle() {
        return this.epsTitle;
    }

    @Nullable
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getJpTitle() {
        return this.jpTitle;
    }

    @Nullable
    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    @Nullable
    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getAiredDate() {
        return this.airedDate;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getImdbId() {
        return this.imdbId;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final boolean getIsAsian() {
        return this.isAsian;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final boolean getIsBollywood() {
        return this.isBollywood;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final boolean getIsCartoon() {
        return this.isCartoon;
    }

    @Nullable
    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getAlttitle() {
        return this.alttitle;
    }

    @Nullable
    /* JADX INFO: renamed from: component24, reason: from getter */
    public final String getNametitle() {
        return this.nametitle;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final boolean getIsDub() {
        return this.isDub;
    }

    @Nullable
    /* JADX INFO: renamed from: component26, reason: from getter */
    public final Boolean getIsMovie() {
        return this.isMovie;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getTvdbId() {
        return this.tvdbId;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getSeason() {
        return this.season;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getEpisode() {
        return this.episode;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getEpid() {
        return this.epid;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getAniId() {
        return this.aniId;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getAnimeId() {
        return this.animeId;
    }

    @NotNull
    public final LinkData copy(@Nullable Integer id, @Nullable String imdbId, @Nullable Integer tvdbId, @Nullable String type, @Nullable Integer season, @Nullable Integer episode, @Nullable Integer epid, @Nullable String aniId, @Nullable String animeId, @Nullable String title, @Nullable Integer year, @Nullable String orgTitle, boolean isAnime, @Nullable Integer airedYear, @Nullable Integer lastSeason, @Nullable String epsTitle, @Nullable String jpTitle, @Nullable String date, @Nullable String airedDate, boolean isAsian, boolean isBollywood, boolean isCartoon, @Nullable String alttitle, @Nullable String nametitle, boolean isDub, @Nullable Boolean isMovie) {
        return new LinkData(id, imdbId, tvdbId, type, season, episode, epid, aniId, animeId, title, year, orgTitle, isAnime, airedYear, lastSeason, epsTitle, jpTitle, date, airedDate, isAsian, isBollywood, isCartoon, alttitle, nametitle, isDub, isMovie);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LinkData)) {
            return false;
        }
        LinkData linkData = (LinkData) other;
        return Intrinsics.areEqual(this.id, linkData.id) && Intrinsics.areEqual(this.imdbId, linkData.imdbId) && Intrinsics.areEqual(this.tvdbId, linkData.tvdbId) && Intrinsics.areEqual(this.type, linkData.type) && Intrinsics.areEqual(this.season, linkData.season) && Intrinsics.areEqual(this.episode, linkData.episode) && Intrinsics.areEqual(this.epid, linkData.epid) && Intrinsics.areEqual(this.aniId, linkData.aniId) && Intrinsics.areEqual(this.animeId, linkData.animeId) && Intrinsics.areEqual(this.title, linkData.title) && Intrinsics.areEqual(this.year, linkData.year) && Intrinsics.areEqual(this.orgTitle, linkData.orgTitle) && this.isAnime == linkData.isAnime && Intrinsics.areEqual(this.airedYear, linkData.airedYear) && Intrinsics.areEqual(this.lastSeason, linkData.lastSeason) && Intrinsics.areEqual(this.epsTitle, linkData.epsTitle) && Intrinsics.areEqual(this.jpTitle, linkData.jpTitle) && Intrinsics.areEqual(this.date, linkData.date) && Intrinsics.areEqual(this.airedDate, linkData.airedDate) && this.isAsian == linkData.isAsian && this.isBollywood == linkData.isBollywood && this.isCartoon == linkData.isCartoon && Intrinsics.areEqual(this.alttitle, linkData.alttitle) && Intrinsics.areEqual(this.nametitle, linkData.nametitle) && this.isDub == linkData.isDub && Intrinsics.areEqual(this.isMovie, linkData.isMovie);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.imdbId == null ? 0 : this.imdbId.hashCode())) * 31) + (this.tvdbId == null ? 0 : this.tvdbId.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episode == null ? 0 : this.episode.hashCode())) * 31) + (this.epid == null ? 0 : this.epid.hashCode())) * 31) + (this.aniId == null ? 0 : this.aniId.hashCode())) * 31) + (this.animeId == null ? 0 : this.animeId.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.orgTitle == null ? 0 : this.orgTitle.hashCode())) * 31) + LinkData$$ExternalSyntheticBackport0.m2m(this.isAnime)) * 31) + (this.airedYear == null ? 0 : this.airedYear.hashCode())) * 31) + (this.lastSeason == null ? 0 : this.lastSeason.hashCode())) * 31) + (this.epsTitle == null ? 0 : this.epsTitle.hashCode())) * 31) + (this.jpTitle == null ? 0 : this.jpTitle.hashCode())) * 31) + (this.date == null ? 0 : this.date.hashCode())) * 31) + (this.airedDate == null ? 0 : this.airedDate.hashCode())) * 31) + LinkData$$ExternalSyntheticBackport0.m2m(this.isAsian)) * 31) + LinkData$$ExternalSyntheticBackport0.m2m(this.isBollywood)) * 31) + LinkData$$ExternalSyntheticBackport0.m2m(this.isCartoon)) * 31) + (this.alttitle == null ? 0 : this.alttitle.hashCode())) * 31) + (this.nametitle == null ? 0 : this.nametitle.hashCode())) * 31) + LinkData$$ExternalSyntheticBackport0.m2m(this.isDub)) * 31) + (this.isMovie != null ? this.isMovie.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkData(id=").append(this.id).append(", imdbId=").append(this.imdbId).append(", tvdbId=").append(this.tvdbId).append(", type=").append(this.type).append(", season=").append(this.season).append(", episode=").append(this.episode).append(", epid=").append(this.epid).append(", aniId=").append(this.aniId).append(", animeId=").append(this.animeId).append(", title=").append(this.title).append(", year=").append(this.year).append(", orgTitle=");
        sb.append(this.orgTitle).append(", isAnime=").append(this.isAnime).append(", airedYear=").append(this.airedYear).append(", lastSeason=").append(this.lastSeason).append(", epsTitle=").append(this.epsTitle).append(", jpTitle=").append(this.jpTitle).append(", date=").append(this.date).append(", airedDate=").append(this.airedDate).append(", isAsian=").append(this.isAsian).append(", isBollywood=").append(this.isBollywood).append(", isCartoon=").append(this.isCartoon).append(", alttitle=").append(this.alttitle);
        sb.append(", nametitle=").append(this.nametitle).append(", isDub=").append(this.isDub).append(", isMovie=").append(this.isMovie).append(')');
        return sb.toString();
    }

    public LinkData(@Nullable Integer id, @Nullable String imdbId, @Nullable Integer tvdbId, @Nullable String type, @Nullable Integer season, @Nullable Integer episode, @Nullable Integer epid, @Nullable String aniId, @Nullable String animeId, @Nullable String title, @Nullable Integer year, @Nullable String orgTitle, boolean isAnime, @Nullable Integer airedYear, @Nullable Integer lastSeason, @Nullable String epsTitle, @Nullable String jpTitle, @Nullable String date, @Nullable String airedDate, boolean isAsian, boolean isBollywood, boolean isCartoon, @Nullable String alttitle, @Nullable String nametitle, boolean isDub, @Nullable Boolean isMovie) {
        this.id = id;
        this.imdbId = imdbId;
        this.tvdbId = tvdbId;
        this.type = type;
        this.season = season;
        this.episode = episode;
        this.epid = epid;
        this.aniId = aniId;
        this.animeId = animeId;
        this.title = title;
        this.year = year;
        this.orgTitle = orgTitle;
        this.isAnime = isAnime;
        this.airedYear = airedYear;
        this.lastSeason = lastSeason;
        this.epsTitle = epsTitle;
        this.jpTitle = jpTitle;
        this.date = date;
        this.airedDate = airedDate;
        this.isAsian = isAsian;
        this.isBollywood = isBollywood;
        this.isCartoon = isCartoon;
        this.alttitle = alttitle;
        this.nametitle = nametitle;
        this.isDub = isDub;
        this.isMovie = isMovie;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ LinkData(Integer num, String str, Integer num2, String str2, Integer num3, Integer num4, Integer num5, String str3, String str4, String str5, Integer num6, String str6, boolean z, Integer num7, Integer num8, String str7, String str8, String str9, String str10, boolean z2, boolean z3, boolean z4, String str11, String str12, boolean z5, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Integer num9 = (i & 1) != 0 ? null : num;
        String str13 = (i & 2) != 0 ? null : str;
        Integer num10 = (i & 4) != 0 ? null : num2;
        String str14 = (i & 8) != 0 ? null : str2;
        Integer num11 = (i & 16) != 0 ? null : num3;
        Integer num12 = (i & 32) != 0 ? null : num4;
        Integer num13 = (i & 64) != 0 ? null : num5;
        String str15 = (i & 128) != 0 ? null : str3;
        String str16 = (i & 256) != 0 ? null : str4;
        String str17 = (i & 512) != 0 ? null : str5;
        Integer num14 = (i & 1024) != 0 ? null : num6;
        String str18 = (i & 2048) != 0 ? null : str6;
        boolean z6 = (i & 4096) != 0 ? false : z;
        Integer num15 = (i & 8192) != 0 ? null : num7;
        this(num9, str13, num10, str14, num11, num12, num13, str15, str16, str17, num14, str18, z6, num15, (i & 16384) != 0 ? null : num8, (i & 32768) != 0 ? null : str7, (i & 65536) != 0 ? null : str8, (i & 131072) != 0 ? null : str9, (i & 262144) != 0 ? null : str10, (i & 524288) != 0 ? false : z2, (i & 1048576) != 0 ? false : z3, (i & 2097152) != 0 ? false : z4, (i & 4194304) != 0 ? null : str11, (i & 8388608) != 0 ? null : str12, (i & 16777216) != 0 ? false : z5, (i & 33554432) != 0 ? false : bool);
    }

    @Nullable
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    public final String getImdbId() {
        return this.imdbId;
    }

    @Nullable
    public final Integer getTvdbId() {
        return this.tvdbId;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final Integer getSeason() {
        return this.season;
    }

    @Nullable
    public final Integer getEpisode() {
        return this.episode;
    }

    @Nullable
    public final Integer getEpid() {
        return this.epid;
    }

    @Nullable
    public final String getAniId() {
        return this.aniId;
    }

    @Nullable
    public final String getAnimeId() {
        return this.animeId;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Integer getYear() {
        return this.year;
    }

    @Nullable
    public final String getOrgTitle() {
        return this.orgTitle;
    }

    public final boolean isAnime() {
        return this.isAnime;
    }

    @Nullable
    public final Integer getAiredYear() {
        return this.airedYear;
    }

    @Nullable
    public final Integer getLastSeason() {
        return this.lastSeason;
    }

    @Nullable
    public final String getEpsTitle() {
        return this.epsTitle;
    }

    @Nullable
    public final String getJpTitle() {
        return this.jpTitle;
    }

    @Nullable
    public final String getDate() {
        return this.date;
    }

    @Nullable
    public final String getAiredDate() {
        return this.airedDate;
    }

    public final boolean isAsian() {
        return this.isAsian;
    }

    public final boolean isBollywood() {
        return this.isBollywood;
    }

    public final boolean isCartoon() {
        return this.isCartoon;
    }

    @Nullable
    public final String getAlttitle() {
        return this.alttitle;
    }

    @Nullable
    public final String getNametitle() {
        return this.nametitle;
    }

    public final boolean isDub() {
        return this.isDub;
    }

    @Nullable
    public final Boolean isMovie() {
        return this.isMovie;
    }
}
