package com.animecloud;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AnimeCloud/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\bR\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bý\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u0012\u0006\u0010\u001d\u001a\u00020\u0005\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\u001f\u001a\u00020\u001b\u0012\u0006\u0010 \u001a\u00020\u001b\u0012\u0006\u0010!\u001a\u00020\u001b\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010#\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b$\u0010%J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0005HÆ\u0003J\t\u0010O\u001a\u00020\u0005HÆ\u0003J\u000f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00050\tHÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0005HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\u0010\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00103J\t\u0010V\u001a\u00020\u0005HÆ\u0003J\t\u0010W\u001a\u00020\u0011HÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0005HÆ\u0003J\t\u0010Z\u001a\u00020\u0005HÆ\u0003J\t\u0010[\u001a\u00020\u0005HÆ\u0003J\t\u0010\\\u001a\u00020\u0005HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\t\u0010`\u001a\u00020\u001bHÆ\u0003J\t\u0010a\u001a\u00020\u0005HÆ\u0003J\t\u0010b\u001a\u00020\u0005HÆ\u0003J\t\u0010c\u001a\u00020\u001bHÆ\u0003J\t\u0010d\u001a\u00020\u001bHÆ\u0003J\t\u0010e\u001a\u00020\u001bHÆ\u0003J\t\u0010f\u001a\u00020\u001bHÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010h\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0002\u0010JJ¾\u0002\u0010i\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020\u001b2\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001bHÆ\u0001¢\u0006\u0002\u0010jJ\u0014\u0010k\u001a\u00020\u001b2\b\u0010l\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010m\u001a\u00020nHÖ\u0081\u0004J\n\u0010o\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010)R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010)R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010'R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010)R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010'R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00104\u001a\u0004\b2\u00103R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010)R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010'R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010)R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u0010)R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010)R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b<\u0010)R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010'R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010'R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010'R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bB\u0010)R\u0011\u0010\u001d\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bC\u0010)R\u0011\u0010\u001e\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\bD\u0010AR\u0011\u0010\u001f\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\bE\u0010AR\u0011\u0010 \u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\bF\u0010AR\u0011\u0010!\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\bG\u0010AR\u0013\u0010\"\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bH\u0010)R\u0015\u0010#\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u0010K\u001a\u0004\bI\u0010J¨\u0006p"}, d2 = {"Lcom/animecloud/HomeDaum;", "", "id", "", "slug", "", "title", "alternateTitles", "generes", "", "imdb", "tmdb", "desc", "start", "end", "poster", "voteAvg", "", "voteCount", "createdAt", "updatedAt", "lastSync", "tmdbType", "anilist", "anilistSyncAttempts", "anilistSuggestedScore", "anilistReviewRequired", "", "backdrop", "itemType", "blockSync", "blockEpisodeSync", "excludeFromAnilist", "autoCache", "takedownExpiresAt", "takedownAuthOnly", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;JLjava/lang/String;JLjava/lang/Long;Ljava/lang/String;DJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJZLjava/lang/String;Ljava/lang/String;ZZZZLjava/lang/String;Ljava/lang/Boolean;)V", "getId", "()J", "getSlug", "()Ljava/lang/String;", "getTitle", "getAlternateTitles", "getGeneres", "()Ljava/util/List;", "getImdb", "getTmdb", "getDesc", "getStart", "getEnd", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPoster", "getVoteAvg", "()D", "getVoteCount", "getCreatedAt", "getUpdatedAt", "getLastSync", "getTmdbType", "getAnilist", "getAnilistSyncAttempts", "getAnilistSuggestedScore", "getAnilistReviewRequired", "()Z", "getBackdrop", "getItemType", "getBlockSync", "getBlockEpisodeSync", "getExcludeFromAnilist", "getAutoCache", "getTakedownExpiresAt", "getTakedownAuthOnly", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;JLjava/lang/String;JLjava/lang/Long;Ljava/lang/String;DJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJZLjava/lang/String;Ljava/lang/String;ZZZZLjava/lang/String;Ljava/lang/Boolean;)Lcom/animecloud/HomeDaum;", "equals", "other", "hashCode", "", "toString", "AnimeCloud"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class HomeDaum {

    @NotNull
    private final String alternateTitles;
    private final long anilist;
    private final boolean anilistReviewRequired;
    private final long anilistSuggestedScore;
    private final long anilistSyncAttempts;
    private final boolean autoCache;

    @NotNull
    private final String backdrop;
    private final boolean blockEpisodeSync;
    private final boolean blockSync;

    @NotNull
    private final String createdAt;

    @NotNull
    private final String desc;

    @Nullable
    private final Long end;
    private final boolean excludeFromAnilist;

    @NotNull
    private final List<String> generes;
    private final long id;

    @Nullable
    private final String imdb;

    @NotNull
    private final String itemType;

    @NotNull
    private final String lastSync;

    @NotNull
    private final String poster;

    @NotNull
    private final String slug;
    private final long start;

    @Nullable
    private final Boolean takedownAuthOnly;

    @Nullable
    private final String takedownExpiresAt;

    @NotNull
    private final String title;
    private final long tmdb;

    @NotNull
    private final String tmdbType;

    @NotNull
    private final String updatedAt;
    private final double voteAvg;
    private final long voteCount;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HomeDaum copy$default(HomeDaum homeDaum, long j, String str, String str2, String str3, List list, String str4, long j2, String str5, long j3, Long l, String str6, double d, long j4, String str7, String str8, String str9, String str10, long j5, long j6, long j7, boolean z, String str11, String str12, boolean z2, boolean z3, boolean z4, boolean z5, String str13, Boolean bool, int i, Object obj) {
        Boolean bool2;
        String str14;
        long j8 = (i & 1) != 0 ? homeDaum.id : j;
        String str15 = (i & 2) != 0 ? homeDaum.slug : str;
        String str16 = (i & 4) != 0 ? homeDaum.title : str2;
        String str17 = (i & 8) != 0 ? homeDaum.alternateTitles : str3;
        List list2 = (i & 16) != 0 ? homeDaum.generes : list;
        String str18 = (i & 32) != 0 ? homeDaum.imdb : str4;
        long j9 = (i & 64) != 0 ? homeDaum.tmdb : j2;
        String str19 = (i & 128) != 0 ? homeDaum.desc : str5;
        long j10 = (i & 256) != 0 ? homeDaum.start : j3;
        Long l2 = (i & 512) != 0 ? homeDaum.end : l;
        String str20 = (i & 1024) != 0 ? homeDaum.poster : str6;
        long j11 = j8;
        double d2 = (i & 2048) != 0 ? homeDaum.voteAvg : d;
        long j12 = (i & 4096) != 0 ? homeDaum.voteCount : j4;
        String str21 = (i & 8192) != 0 ? homeDaum.createdAt : str7;
        String str22 = (i & 16384) != 0 ? homeDaum.updatedAt : str8;
        String str23 = (i & 32768) != 0 ? homeDaum.lastSync : str9;
        String str24 = (i & 65536) != 0 ? homeDaum.tmdbType : str10;
        String str25 = str21;
        long j13 = (i & 131072) != 0 ? homeDaum.anilist : j5;
        long j14 = (i & 262144) != 0 ? homeDaum.anilistSyncAttempts : j6;
        long j15 = (i & 524288) != 0 ? homeDaum.anilistSuggestedScore : j7;
        boolean z6 = (i & 1048576) != 0 ? homeDaum.anilistReviewRequired : z;
        String str26 = (i & 2097152) != 0 ? homeDaum.backdrop : str11;
        boolean z7 = z6;
        String str27 = (i & 4194304) != 0 ? homeDaum.itemType : str12;
        boolean z8 = (i & 8388608) != 0 ? homeDaum.blockSync : z2;
        boolean z9 = (i & 16777216) != 0 ? homeDaum.blockEpisodeSync : z3;
        boolean z10 = (i & 33554432) != 0 ? homeDaum.excludeFromAnilist : z4;
        boolean z11 = (i & 67108864) != 0 ? homeDaum.autoCache : z5;
        String str28 = (i & 134217728) != 0 ? homeDaum.takedownExpiresAt : str13;
        if ((i & 268435456) != 0) {
            str14 = str28;
            bool2 = homeDaum.takedownAuthOnly;
        } else {
            bool2 = bool;
            str14 = str28;
        }
        return homeDaum.copy(j11, str15, str16, str17, list2, str18, j9, str19, j10, l2, str20, d2, j12, str25, str22, str23, str24, j13, j14, j15, z7, str26, str27, z8, z9, z10, z11, str14, bool2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Long getEnd() {
        return this.end;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getPoster() {
        return this.poster;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final double getVoteAvg() {
        return this.voteAvg;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final long getVoteCount() {
        return this.voteCount;
    }

    @NotNull
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    @NotNull
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    @NotNull
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getLastSync() {
        return this.lastSync;
    }

    @NotNull
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getTmdbType() {
        return this.tmdbType;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final long getAnilist() {
        return this.anilist;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final long getAnilistSyncAttempts() {
        return this.anilistSyncAttempts;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSlug() {
        return this.slug;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final long getAnilistSuggestedScore() {
        return this.anilistSuggestedScore;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final boolean getAnilistReviewRequired() {
        return this.anilistReviewRequired;
    }

    @NotNull
    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getBackdrop() {
        return this.backdrop;
    }

    @NotNull
    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getItemType() {
        return this.itemType;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final boolean getBlockSync() {
        return this.blockSync;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final boolean getBlockEpisodeSync() {
        return this.blockEpisodeSync;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final boolean getExcludeFromAnilist() {
        return this.excludeFromAnilist;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final boolean getAutoCache() {
        return this.autoCache;
    }

    @Nullable
    /* JADX INFO: renamed from: component28, reason: from getter */
    public final String getTakedownExpiresAt() {
        return this.takedownExpiresAt;
    }

    @Nullable
    /* JADX INFO: renamed from: component29, reason: from getter */
    public final Boolean getTakedownAuthOnly() {
        return this.takedownAuthOnly;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAlternateTitles() {
        return this.alternateTitles;
    }

    @NotNull
    public final List<String> component5() {
        return this.generes;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getImdb() {
        return this.imdb;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getTmdb() {
        return this.tmdb;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getStart() {
        return this.start;
    }

    @NotNull
    public final HomeDaum copy(long id, @NotNull String slug, @NotNull String title, @NotNull String alternateTitles, @NotNull List<String> generes, @Nullable String imdb, long tmdb, @NotNull String desc, long start, @Nullable Long end, @NotNull String poster, double voteAvg, long voteCount, @NotNull String createdAt, @NotNull String updatedAt, @NotNull String lastSync, @NotNull String tmdbType, long anilist, long anilistSyncAttempts, long anilistSuggestedScore, boolean anilistReviewRequired, @NotNull String backdrop, @NotNull String itemType, boolean blockSync, boolean blockEpisodeSync, boolean excludeFromAnilist, boolean autoCache, @Nullable String takedownExpiresAt, @Nullable Boolean takedownAuthOnly) {
        return new HomeDaum(id, slug, title, alternateTitles, generes, imdb, tmdb, desc, start, end, poster, voteAvg, voteCount, createdAt, updatedAt, lastSync, tmdbType, anilist, anilistSyncAttempts, anilistSuggestedScore, anilistReviewRequired, backdrop, itemType, blockSync, blockEpisodeSync, excludeFromAnilist, autoCache, takedownExpiresAt, takedownAuthOnly);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomeDaum)) {
            return false;
        }
        HomeDaum homeDaum = (HomeDaum) other;
        return this.id == homeDaum.id && Intrinsics.areEqual(this.slug, homeDaum.slug) && Intrinsics.areEqual(this.title, homeDaum.title) && Intrinsics.areEqual(this.alternateTitles, homeDaum.alternateTitles) && Intrinsics.areEqual(this.generes, homeDaum.generes) && Intrinsics.areEqual(this.imdb, homeDaum.imdb) && this.tmdb == homeDaum.tmdb && Intrinsics.areEqual(this.desc, homeDaum.desc) && this.start == homeDaum.start && Intrinsics.areEqual(this.end, homeDaum.end) && Intrinsics.areEqual(this.poster, homeDaum.poster) && Double.compare(this.voteAvg, homeDaum.voteAvg) == 0 && this.voteCount == homeDaum.voteCount && Intrinsics.areEqual(this.createdAt, homeDaum.createdAt) && Intrinsics.areEqual(this.updatedAt, homeDaum.updatedAt) && Intrinsics.areEqual(this.lastSync, homeDaum.lastSync) && Intrinsics.areEqual(this.tmdbType, homeDaum.tmdbType) && this.anilist == homeDaum.anilist && this.anilistSyncAttempts == homeDaum.anilistSyncAttempts && this.anilistSuggestedScore == homeDaum.anilistSuggestedScore && this.anilistReviewRequired == homeDaum.anilistReviewRequired && Intrinsics.areEqual(this.backdrop, homeDaum.backdrop) && Intrinsics.areEqual(this.itemType, homeDaum.itemType) && this.blockSync == homeDaum.blockSync && this.blockEpisodeSync == homeDaum.blockEpisodeSync && this.excludeFromAnilist == homeDaum.excludeFromAnilist && this.autoCache == homeDaum.autoCache && Intrinsics.areEqual(this.takedownExpiresAt, homeDaum.takedownExpiresAt) && Intrinsics.areEqual(this.takedownAuthOnly, homeDaum.takedownAuthOnly);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((HomeDaum$$ExternalSyntheticBackport0.m6m(this.id) * 31) + this.slug.hashCode()) * 31) + this.title.hashCode()) * 31) + this.alternateTitles.hashCode()) * 31) + this.generes.hashCode()) * 31) + (this.imdb == null ? 0 : this.imdb.hashCode())) * 31) + HomeDaum$$ExternalSyntheticBackport0.m6m(this.tmdb)) * 31) + this.desc.hashCode()) * 31) + HomeDaum$$ExternalSyntheticBackport0.m6m(this.start)) * 31) + (this.end == null ? 0 : this.end.hashCode())) * 31) + this.poster.hashCode()) * 31) + HomeDaum$$ExternalSyntheticBackport2.m8m(this.voteAvg)) * 31) + HomeDaum$$ExternalSyntheticBackport0.m6m(this.voteCount)) * 31) + this.createdAt.hashCode()) * 31) + this.updatedAt.hashCode()) * 31) + this.lastSync.hashCode()) * 31) + this.tmdbType.hashCode()) * 31) + HomeDaum$$ExternalSyntheticBackport0.m6m(this.anilist)) * 31) + HomeDaum$$ExternalSyntheticBackport0.m6m(this.anilistSyncAttempts)) * 31) + HomeDaum$$ExternalSyntheticBackport0.m6m(this.anilistSuggestedScore)) * 31) + HomeDaum$$ExternalSyntheticBackport1.m7m(this.anilistReviewRequired)) * 31) + this.backdrop.hashCode()) * 31) + this.itemType.hashCode()) * 31) + HomeDaum$$ExternalSyntheticBackport1.m7m(this.blockSync)) * 31) + HomeDaum$$ExternalSyntheticBackport1.m7m(this.blockEpisodeSync)) * 31) + HomeDaum$$ExternalSyntheticBackport1.m7m(this.excludeFromAnilist)) * 31) + HomeDaum$$ExternalSyntheticBackport1.m7m(this.autoCache)) * 31) + (this.takedownExpiresAt == null ? 0 : this.takedownExpiresAt.hashCode())) * 31) + (this.takedownAuthOnly != null ? this.takedownAuthOnly.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HomeDaum(id=").append(this.id).append(", slug=").append(this.slug).append(", title=").append(this.title).append(", alternateTitles=").append(this.alternateTitles).append(", generes=").append(this.generes).append(", imdb=").append(this.imdb).append(", tmdb=").append(this.tmdb).append(", desc=").append(this.desc).append(", start=").append(this.start).append(", end=").append(this.end).append(", poster=").append(this.poster).append(", voteAvg=");
        sb.append(this.voteAvg).append(", voteCount=").append(this.voteCount).append(", createdAt=").append(this.createdAt).append(", updatedAt=").append(this.updatedAt).append(", lastSync=").append(this.lastSync).append(", tmdbType=").append(this.tmdbType).append(", anilist=").append(this.anilist).append(", anilistSyncAttempts=").append(this.anilistSyncAttempts).append(", anilistSuggestedScore=").append(this.anilistSuggestedScore).append(", anilistReviewRequired=").append(this.anilistReviewRequired).append(", backdrop=").append(this.backdrop).append(", itemType=").append(this.itemType);
        sb.append(", blockSync=").append(this.blockSync).append(", blockEpisodeSync=").append(this.blockEpisodeSync).append(", excludeFromAnilist=").append(this.excludeFromAnilist).append(", autoCache=").append(this.autoCache).append(", takedownExpiresAt=").append(this.takedownExpiresAt).append(", takedownAuthOnly=").append(this.takedownAuthOnly).append(')');
        return sb.toString();
    }

    public HomeDaum(long id, @NotNull String slug, @NotNull String title, @NotNull String alternateTitles, @NotNull List<String> list, @Nullable String imdb, long tmdb, @NotNull String desc, long start, @Nullable Long end, @NotNull String poster, double voteAvg, long voteCount, @NotNull String createdAt, @NotNull String updatedAt, @NotNull String lastSync, @NotNull String tmdbType, long anilist, long anilistSyncAttempts, long anilistSuggestedScore, boolean anilistReviewRequired, @NotNull String backdrop, @NotNull String itemType, boolean blockSync, boolean blockEpisodeSync, boolean excludeFromAnilist, boolean autoCache, @Nullable String takedownExpiresAt, @Nullable Boolean takedownAuthOnly) {
        this.id = id;
        this.slug = slug;
        this.title = title;
        this.alternateTitles = alternateTitles;
        this.generes = list;
        this.imdb = imdb;
        this.tmdb = tmdb;
        this.desc = desc;
        this.start = start;
        this.end = end;
        this.poster = poster;
        this.voteAvg = voteAvg;
        this.voteCount = voteCount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.lastSync = lastSync;
        this.tmdbType = tmdbType;
        this.anilist = anilist;
        this.anilistSyncAttempts = anilistSyncAttempts;
        this.anilistSuggestedScore = anilistSuggestedScore;
        this.anilistReviewRequired = anilistReviewRequired;
        this.backdrop = backdrop;
        this.itemType = itemType;
        this.blockSync = blockSync;
        this.blockEpisodeSync = blockEpisodeSync;
        this.excludeFromAnilist = excludeFromAnilist;
        this.autoCache = autoCache;
        this.takedownExpiresAt = takedownExpiresAt;
        this.takedownAuthOnly = takedownAuthOnly;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getSlug() {
        return this.slug;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getAlternateTitles() {
        return this.alternateTitles;
    }

    @NotNull
    public final List<String> getGeneres() {
        return this.generes;
    }

    @Nullable
    public final String getImdb() {
        return this.imdb;
    }

    public final long getTmdb() {
        return this.tmdb;
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    public final long getStart() {
        return this.start;
    }

    @Nullable
    public final Long getEnd() {
        return this.end;
    }

    @NotNull
    public final String getPoster() {
        return this.poster;
    }

    public final double getVoteAvg() {
        return this.voteAvg;
    }

    public final long getVoteCount() {
        return this.voteCount;
    }

    @NotNull
    public final String getCreatedAt() {
        return this.createdAt;
    }

    @NotNull
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    @NotNull
    public final String getLastSync() {
        return this.lastSync;
    }

    @NotNull
    public final String getTmdbType() {
        return this.tmdbType;
    }

    public final long getAnilist() {
        return this.anilist;
    }

    public final long getAnilistSyncAttempts() {
        return this.anilistSyncAttempts;
    }

    public final long getAnilistSuggestedScore() {
        return this.anilistSuggestedScore;
    }

    public final boolean getAnilistReviewRequired() {
        return this.anilistReviewRequired;
    }

    @NotNull
    public final String getBackdrop() {
        return this.backdrop;
    }

    @NotNull
    public final String getItemType() {
        return this.itemType;
    }

    public final boolean getBlockSync() {
        return this.blockSync;
    }

    public final boolean getBlockEpisodeSync() {
        return this.blockEpisodeSync;
    }

    public final boolean getExcludeFromAnilist() {
        return this.excludeFromAnilist;
    }

    public final boolean getAutoCache() {
        return this.autoCache;
    }

    @Nullable
    public final String getTakedownExpiresAt() {
        return this.takedownExpiresAt;
    }

    @Nullable
    public final Boolean getTakedownAuthOnly() {
        return this.takedownAuthOnly;
    }
}
