package com.animecloud;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/AnimeCloud/classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\bH\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BÓ\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001b\u0012\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\t¢\u0006\u0004\b$\u0010%J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00050\tHÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00100J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00100J\u000b\u0010U\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010V\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u00107J\u0010\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00100J\u000b\u0010X\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010_\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0002\u0010BJ\u000b\u0010`\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010b\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0002\u0010BJ\u0010\u0010c\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0002\u0010BJ\u0010\u0010d\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0002\u0010BJ\u0010\u0010e\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0002\u0010BJ\u000f\u0010f\u001a\b\u0012\u0004\u0012\u00020#0\tHÆ\u0003Jà\u0002\u0010g\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001b2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\tHÆ\u0001¢\u0006\u0002\u0010hJ\u0014\u0010i\u001a\u00020\u001b2\b\u0010j\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010k\u001a\u00020lHÖ\u0081\u0004J\n\u0010m\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010)R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010)R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010)R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00101\u001a\u0004\b3\u00100R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00101\u001a\u0004\b4\u00100R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010)R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u00108\u001a\u0004\b6\u00107R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00101\u001a\u0004\b9\u00100R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u0010)R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010)R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b<\u0010)R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b=\u0010)R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00101\u001a\u0004\b>\u00100R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00101\u001a\u0004\b?\u00100R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00101\u001a\u0004\b@\u00100R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u0010C\u001a\u0004\bA\u0010BR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bD\u0010)R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bE\u0010)R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u0010C\u001a\u0004\bF\u0010BR\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u0010C\u001a\u0004\bG\u0010BR\u0015\u0010 \u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u0010C\u001a\u0004\bH\u0010BR\u0015\u0010!\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u0010C\u001a\u0004\bI\u0010BR\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\t¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010-¨\u0006n"}, d2 = {"Lcom/animecloud/Data;", "", "id", "", "slug", "", "title", "alternateTitles", "generes", "", "imdb", "tmdb", "desc", "start", "end", "poster", "voteAvg", "", "voteCount", "createdAt", "updatedAt", "lastSync", "tmdbType", "anilist", "anilistSyncAttempts", "anilistSuggestedScore", "anilistReviewRequired", "", "backdrop", "itemType", "blockSync", "blockEpisodeSync", "excludeFromAnilist", "autoCache", "animeSeasons", "Lcom/animecloud/AnimeSeason;", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;)V", "getId", "()J", "getSlug", "()Ljava/lang/String;", "getTitle", "getAlternateTitles", "getGeneres", "()Ljava/util/List;", "getImdb", "getTmdb", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDesc", "getStart", "getEnd", "getPoster", "getVoteAvg", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getVoteCount", "getCreatedAt", "getUpdatedAt", "getLastSync", "getTmdbType", "getAnilist", "getAnilistSyncAttempts", "getAnilistSuggestedScore", "getAnilistReviewRequired", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBackdrop", "getItemType", "getBlockSync", "getBlockEpisodeSync", "getExcludeFromAnilist", "getAutoCache", "getAnimeSeasons", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;)Lcom/animecloud/Data;", "equals", "other", "hashCode", "", "toString", "AnimeCloud"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Data {

    @Nullable
    private final String alternateTitles;

    @Nullable
    private final Long anilist;

    @Nullable
    private final Boolean anilistReviewRequired;

    @Nullable
    private final Long anilistSuggestedScore;

    @Nullable
    private final Long anilistSyncAttempts;

    @NotNull
    private final List<AnimeSeason> animeSeasons;

    @Nullable
    private final Boolean autoCache;

    @Nullable
    private final String backdrop;

    @Nullable
    private final Boolean blockEpisodeSync;

    @Nullable
    private final Boolean blockSync;

    @Nullable
    private final String createdAt;

    @Nullable
    private final String desc;

    @Nullable
    private final Long end;

    @Nullable
    private final Boolean excludeFromAnilist;

    @NotNull
    private final List<String> generes;
    private final long id;

    @Nullable
    private final String imdb;

    @Nullable
    private final String itemType;

    @Nullable
    private final String lastSync;

    @Nullable
    private final String poster;

    @NotNull
    private final String slug;

    @Nullable
    private final Long start;

    @NotNull
    private final String title;

    @Nullable
    private final Long tmdb;

    @Nullable
    private final String tmdbType;

    @Nullable
    private final String updatedAt;

    @Nullable
    private final Double voteAvg;

    @Nullable
    private final Long voteCount;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Data copy$default(Data data, long j, String str, String str2, String str3, List list, String str4, Long l, String str5, Long l2, Long l3, String str6, Double d, Long l4, String str7, String str8, String str9, String str10, Long l5, Long l6, Long l7, Boolean bool, String str11, String str12, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, List list2, int i, Object obj) {
        List list3;
        Boolean bool6;
        long j2 = (i & 1) != 0 ? data.id : j;
        String str13 = (i & 2) != 0 ? data.slug : str;
        String str14 = (i & 4) != 0 ? data.title : str2;
        String str15 = (i & 8) != 0 ? data.alternateTitles : str3;
        List list4 = (i & 16) != 0 ? data.generes : list;
        String str16 = (i & 32) != 0 ? data.imdb : str4;
        Long l8 = (i & 64) != 0 ? data.tmdb : l;
        String str17 = (i & 128) != 0 ? data.desc : str5;
        Long l9 = (i & 256) != 0 ? data.start : l2;
        Long l10 = (i & 512) != 0 ? data.end : l3;
        String str18 = (i & 1024) != 0 ? data.poster : str6;
        Double d2 = (i & 2048) != 0 ? data.voteAvg : d;
        Long l11 = (i & 4096) != 0 ? data.voteCount : l4;
        long j3 = j2;
        String str19 = (i & 8192) != 0 ? data.createdAt : str7;
        String str20 = (i & 16384) != 0 ? data.updatedAt : str8;
        String str21 = (i & 32768) != 0 ? data.lastSync : str9;
        String str22 = (i & 65536) != 0 ? data.tmdbType : str10;
        Long l12 = (i & 131072) != 0 ? data.anilist : l5;
        Long l13 = (i & 262144) != 0 ? data.anilistSyncAttempts : l6;
        Long l14 = (i & 524288) != 0 ? data.anilistSuggestedScore : l7;
        Boolean bool7 = (i & 1048576) != 0 ? data.anilistReviewRequired : bool;
        String str23 = (i & 2097152) != 0 ? data.backdrop : str11;
        String str24 = (i & 4194304) != 0 ? data.itemType : str12;
        Boolean bool8 = (i & 8388608) != 0 ? data.blockSync : bool2;
        Boolean bool9 = (i & 16777216) != 0 ? data.blockEpisodeSync : bool3;
        Boolean bool10 = (i & 33554432) != 0 ? data.excludeFromAnilist : bool4;
        Boolean bool11 = (i & 67108864) != 0 ? data.autoCache : bool5;
        if ((i & 134217728) != 0) {
            bool6 = bool11;
            list3 = data.animeSeasons;
        } else {
            list3 = list2;
            bool6 = bool11;
        }
        return data.copy(j3, str13, str14, str15, list4, str16, l8, str17, l9, l10, str18, d2, l11, str19, str20, str21, str22, l12, l13, l14, bool7, str23, str24, bool8, bool9, bool10, bool6, list3);
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

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getPoster() {
        return this.poster;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Double getVoteAvg() {
        return this.voteAvg;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Long getVoteCount() {
        return this.voteCount;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    @Nullable
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    @Nullable
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getLastSync() {
        return this.lastSync;
    }

    @Nullable
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getTmdbType() {
        return this.tmdbType;
    }

    @Nullable
    /* JADX INFO: renamed from: component18, reason: from getter */
    public final Long getAnilist() {
        return this.anilist;
    }

    @Nullable
    /* JADX INFO: renamed from: component19, reason: from getter */
    public final Long getAnilistSyncAttempts() {
        return this.anilistSyncAttempts;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSlug() {
        return this.slug;
    }

    @Nullable
    /* JADX INFO: renamed from: component20, reason: from getter */
    public final Long getAnilistSuggestedScore() {
        return this.anilistSuggestedScore;
    }

    @Nullable
    /* JADX INFO: renamed from: component21, reason: from getter */
    public final Boolean getAnilistReviewRequired() {
        return this.anilistReviewRequired;
    }

    @Nullable
    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getBackdrop() {
        return this.backdrop;
    }

    @Nullable
    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getItemType() {
        return this.itemType;
    }

    @Nullable
    /* JADX INFO: renamed from: component24, reason: from getter */
    public final Boolean getBlockSync() {
        return this.blockSync;
    }

    @Nullable
    /* JADX INFO: renamed from: component25, reason: from getter */
    public final Boolean getBlockEpisodeSync() {
        return this.blockEpisodeSync;
    }

    @Nullable
    /* JADX INFO: renamed from: component26, reason: from getter */
    public final Boolean getExcludeFromAnilist() {
        return this.excludeFromAnilist;
    }

    @Nullable
    /* JADX INFO: renamed from: component27, reason: from getter */
    public final Boolean getAutoCache() {
        return this.autoCache;
    }

    @NotNull
    public final List<AnimeSeason> component28() {
        return this.animeSeasons;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
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

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Long getTmdb() {
        return this.tmdb;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Long getStart() {
        return this.start;
    }

    @NotNull
    public final Data copy(long id, @NotNull String slug, @NotNull String title, @Nullable String alternateTitles, @NotNull List<String> generes, @Nullable String imdb, @Nullable Long tmdb, @Nullable String desc, @Nullable Long start, @Nullable Long end, @Nullable String poster, @Nullable Double voteAvg, @Nullable Long voteCount, @Nullable String createdAt, @Nullable String updatedAt, @Nullable String lastSync, @Nullable String tmdbType, @Nullable Long anilist, @Nullable Long anilistSyncAttempts, @Nullable Long anilistSuggestedScore, @Nullable Boolean anilistReviewRequired, @Nullable String backdrop, @Nullable String itemType, @Nullable Boolean blockSync, @Nullable Boolean blockEpisodeSync, @Nullable Boolean excludeFromAnilist, @Nullable Boolean autoCache, @NotNull List<AnimeSeason> animeSeasons) {
        return new Data(id, slug, title, alternateTitles, generes, imdb, tmdb, desc, start, end, poster, voteAvg, voteCount, createdAt, updatedAt, lastSync, tmdbType, anilist, anilistSyncAttempts, anilistSuggestedScore, anilistReviewRequired, backdrop, itemType, blockSync, blockEpisodeSync, excludeFromAnilist, autoCache, animeSeasons);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Data)) {
            return false;
        }
        Data data = (Data) other;
        return this.id == data.id && Intrinsics.areEqual(this.slug, data.slug) && Intrinsics.areEqual(this.title, data.title) && Intrinsics.areEqual(this.alternateTitles, data.alternateTitles) && Intrinsics.areEqual(this.generes, data.generes) && Intrinsics.areEqual(this.imdb, data.imdb) && Intrinsics.areEqual(this.tmdb, data.tmdb) && Intrinsics.areEqual(this.desc, data.desc) && Intrinsics.areEqual(this.start, data.start) && Intrinsics.areEqual(this.end, data.end) && Intrinsics.areEqual(this.poster, data.poster) && Intrinsics.areEqual(this.voteAvg, data.voteAvg) && Intrinsics.areEqual(this.voteCount, data.voteCount) && Intrinsics.areEqual(this.createdAt, data.createdAt) && Intrinsics.areEqual(this.updatedAt, data.updatedAt) && Intrinsics.areEqual(this.lastSync, data.lastSync) && Intrinsics.areEqual(this.tmdbType, data.tmdbType) && Intrinsics.areEqual(this.anilist, data.anilist) && Intrinsics.areEqual(this.anilistSyncAttempts, data.anilistSyncAttempts) && Intrinsics.areEqual(this.anilistSuggestedScore, data.anilistSuggestedScore) && Intrinsics.areEqual(this.anilistReviewRequired, data.anilistReviewRequired) && Intrinsics.areEqual(this.backdrop, data.backdrop) && Intrinsics.areEqual(this.itemType, data.itemType) && Intrinsics.areEqual(this.blockSync, data.blockSync) && Intrinsics.areEqual(this.blockEpisodeSync, data.blockEpisodeSync) && Intrinsics.areEqual(this.excludeFromAnilist, data.excludeFromAnilist) && Intrinsics.areEqual(this.autoCache, data.autoCache) && Intrinsics.areEqual(this.animeSeasons, data.animeSeasons);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((Data$$ExternalSyntheticBackport0.m3m(this.id) * 31) + this.slug.hashCode()) * 31) + this.title.hashCode()) * 31) + (this.alternateTitles == null ? 0 : this.alternateTitles.hashCode())) * 31) + this.generes.hashCode()) * 31) + (this.imdb == null ? 0 : this.imdb.hashCode())) * 31) + (this.tmdb == null ? 0 : this.tmdb.hashCode())) * 31) + (this.desc == null ? 0 : this.desc.hashCode())) * 31) + (this.start == null ? 0 : this.start.hashCode())) * 31) + (this.end == null ? 0 : this.end.hashCode())) * 31) + (this.poster == null ? 0 : this.poster.hashCode())) * 31) + (this.voteAvg == null ? 0 : this.voteAvg.hashCode())) * 31) + (this.voteCount == null ? 0 : this.voteCount.hashCode())) * 31) + (this.createdAt == null ? 0 : this.createdAt.hashCode())) * 31) + (this.updatedAt == null ? 0 : this.updatedAt.hashCode())) * 31) + (this.lastSync == null ? 0 : this.lastSync.hashCode())) * 31) + (this.tmdbType == null ? 0 : this.tmdbType.hashCode())) * 31) + (this.anilist == null ? 0 : this.anilist.hashCode())) * 31) + (this.anilistSyncAttempts == null ? 0 : this.anilistSyncAttempts.hashCode())) * 31) + (this.anilistSuggestedScore == null ? 0 : this.anilistSuggestedScore.hashCode())) * 31) + (this.anilistReviewRequired == null ? 0 : this.anilistReviewRequired.hashCode())) * 31) + (this.backdrop == null ? 0 : this.backdrop.hashCode())) * 31) + (this.itemType == null ? 0 : this.itemType.hashCode())) * 31) + (this.blockSync == null ? 0 : this.blockSync.hashCode())) * 31) + (this.blockEpisodeSync == null ? 0 : this.blockEpisodeSync.hashCode())) * 31) + (this.excludeFromAnilist == null ? 0 : this.excludeFromAnilist.hashCode())) * 31) + (this.autoCache != null ? this.autoCache.hashCode() : 0)) * 31) + this.animeSeasons.hashCode();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Data(id=").append(this.id).append(", slug=").append(this.slug).append(", title=").append(this.title).append(", alternateTitles=").append(this.alternateTitles).append(", generes=").append(this.generes).append(", imdb=").append(this.imdb).append(", tmdb=").append(this.tmdb).append(", desc=").append(this.desc).append(", start=").append(this.start).append(", end=").append(this.end).append(", poster=").append(this.poster).append(", voteAvg=");
        sb.append(this.voteAvg).append(", voteCount=").append(this.voteCount).append(", createdAt=").append(this.createdAt).append(", updatedAt=").append(this.updatedAt).append(", lastSync=").append(this.lastSync).append(", tmdbType=").append(this.tmdbType).append(", anilist=").append(this.anilist).append(", anilistSyncAttempts=").append(this.anilistSyncAttempts).append(", anilistSuggestedScore=").append(this.anilistSuggestedScore).append(", anilistReviewRequired=").append(this.anilistReviewRequired).append(", backdrop=").append(this.backdrop).append(", itemType=").append(this.itemType);
        sb.append(", blockSync=").append(this.blockSync).append(", blockEpisodeSync=").append(this.blockEpisodeSync).append(", excludeFromAnilist=").append(this.excludeFromAnilist).append(", autoCache=").append(this.autoCache).append(", animeSeasons=").append(this.animeSeasons).append(')');
        return sb.toString();
    }

    public Data(long id, @NotNull String slug, @NotNull String title, @Nullable String alternateTitles, @NotNull List<String> list, @Nullable String imdb, @Nullable Long tmdb, @Nullable String desc, @Nullable Long start, @Nullable Long end, @Nullable String poster, @Nullable Double voteAvg, @Nullable Long voteCount, @Nullable String createdAt, @Nullable String updatedAt, @Nullable String lastSync, @Nullable String tmdbType, @Nullable Long anilist, @Nullable Long anilistSyncAttempts, @Nullable Long anilistSuggestedScore, @Nullable Boolean anilistReviewRequired, @Nullable String backdrop, @Nullable String itemType, @Nullable Boolean blockSync, @Nullable Boolean blockEpisodeSync, @Nullable Boolean excludeFromAnilist, @Nullable Boolean autoCache, @NotNull List<AnimeSeason> list2) {
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
        this.animeSeasons = list2;
    }

    public /* synthetic */ Data(long j, String str, String str2, String str3, List list, String str4, Long l, String str5, Long l2, Long l3, String str6, Double d, Long l4, String str7, String str8, String str9, String str10, Long l5, Long l6, Long l7, Boolean bool, String str11, String str12, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? CollectionsKt.emptyList() : list, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : l, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : l2, (i & 512) != 0 ? null : l3, (i & 1024) != 0 ? null : str6, (i & 2048) != 0 ? null : d, (i & 4096) != 0 ? null : l4, (i & 8192) != 0 ? null : str7, (i & 16384) != 0 ? null : str8, (32768 & i) != 0 ? null : str9, (65536 & i) != 0 ? null : str10, (131072 & i) != 0 ? null : l5, (262144 & i) != 0 ? null : l6, (524288 & i) != 0 ? null : l7, (1048576 & i) != 0 ? null : bool, (2097152 & i) != 0 ? null : str11, (4194304 & i) != 0 ? null : str12, (8388608 & i) != 0 ? null : bool2, (16777216 & i) != 0 ? null : bool3, (33554432 & i) != 0 ? null : bool4, (67108864 & i) != 0 ? null : bool5, (i & 134217728) != 0 ? CollectionsKt.emptyList() : list2);
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

    @Nullable
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

    @Nullable
    public final Long getTmdb() {
        return this.tmdb;
    }

    @Nullable
    public final String getDesc() {
        return this.desc;
    }

    @Nullable
    public final Long getStart() {
        return this.start;
    }

    @Nullable
    public final Long getEnd() {
        return this.end;
    }

    @Nullable
    public final String getPoster() {
        return this.poster;
    }

    @Nullable
    public final Double getVoteAvg() {
        return this.voteAvg;
    }

    @Nullable
    public final Long getVoteCount() {
        return this.voteCount;
    }

    @Nullable
    public final String getCreatedAt() {
        return this.createdAt;
    }

    @Nullable
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    @Nullable
    public final String getLastSync() {
        return this.lastSync;
    }

    @Nullable
    public final String getTmdbType() {
        return this.tmdbType;
    }

    @Nullable
    public final Long getAnilist() {
        return this.anilist;
    }

    @Nullable
    public final Long getAnilistSyncAttempts() {
        return this.anilistSyncAttempts;
    }

    @Nullable
    public final Long getAnilistSuggestedScore() {
        return this.anilistSuggestedScore;
    }

    @Nullable
    public final Boolean getAnilistReviewRequired() {
        return this.anilistReviewRequired;
    }

    @Nullable
    public final String getBackdrop() {
        return this.backdrop;
    }

    @Nullable
    public final String getItemType() {
        return this.itemType;
    }

    @Nullable
    public final Boolean getBlockSync() {
        return this.blockSync;
    }

    @Nullable
    public final Boolean getBlockEpisodeSync() {
        return this.blockEpisodeSync;
    }

    @Nullable
    public final Boolean getExcludeFromAnilist() {
        return this.excludeFromAnilist;
    }

    @Nullable
    public final Boolean getAutoCache() {
        return this.autoCache;
    }

    @NotNull
    public final List<AnimeSeason> getAnimeSeasons() {
        return this.animeSeasons;
    }
}
