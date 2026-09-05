package com.animecloud;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AnimeCloud/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050\tHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0011HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\u009a\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u00106J\u0014\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010:\u001a\u00020;HÖ\u0081\u0004J\n\u0010<\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0016¨\u0006="}, d2 = {"Lcom/animecloud/Search;", "", "id", "", "slug", "", "title", "alternateTitles", "generes", "", "imdb", "tmdb", "desc", "start", "end", "poster", "voteAvg", "", "voteCount", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;JLjava/lang/String;JLjava/lang/Long;Ljava/lang/String;DJ)V", "getId", "()J", "getSlug", "()Ljava/lang/String;", "getTitle", "getAlternateTitles", "getGeneres", "()Ljava/util/List;", "getImdb", "getTmdb", "getDesc", "getStart", "getEnd", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPoster", "getVoteAvg", "()D", "getVoteCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;JLjava/lang/String;JLjava/lang/Long;Ljava/lang/String;DJ)Lcom/animecloud/Search;", "equals", "", "other", "hashCode", "", "toString", "AnimeCloud"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Search {

    @NotNull
    private final String alternateTitles;

    @NotNull
    private final String desc;

    @Nullable
    private final Long end;

    @NotNull
    private final List<String> generes;
    private final long id;

    @Nullable
    private final String imdb;

    @NotNull
    private final String poster;

    @NotNull
    private final String slug;
    private final long start;

    @NotNull
    private final String title;
    private final long tmdb;
    private final double voteAvg;
    private final long voteCount;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Search copy$default(Search search, long j, String str, String str2, String str3, List list, String str4, long j2, String str5, long j3, Long l, String str6, double d, long j4, int i, Object obj) {
        long j5;
        double d2;
        long j6 = (i & 1) != 0 ? search.id : j;
        String str7 = (i & 2) != 0 ? search.slug : str;
        String str8 = (i & 4) != 0 ? search.title : str2;
        String str9 = (i & 8) != 0 ? search.alternateTitles : str3;
        List list2 = (i & 16) != 0 ? search.generes : list;
        String str10 = (i & 32) != 0 ? search.imdb : str4;
        long j7 = (i & 64) != 0 ? search.tmdb : j2;
        String str11 = (i & 128) != 0 ? search.desc : str5;
        long j8 = (i & 256) != 0 ? search.start : j3;
        Long l2 = (i & 512) != 0 ? search.end : l;
        String str12 = (i & 1024) != 0 ? search.poster : str6;
        long j9 = j6;
        double d3 = (i & 2048) != 0 ? search.voteAvg : d;
        if ((i & 4096) != 0) {
            d2 = d3;
            j5 = search.voteCount;
        } else {
            j5 = j4;
            d2 = d3;
        }
        return search.copy(j9, str7, str8, str9, list2, str10, j7, str11, j8, l2, str12, d2, j5);
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
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSlug() {
        return this.slug;
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
    public final Search copy(long id, @NotNull String slug, @NotNull String title, @NotNull String alternateTitles, @NotNull List<String> generes, @Nullable String imdb, long tmdb, @NotNull String desc, long start, @Nullable Long end, @NotNull String poster, double voteAvg, long voteCount) {
        return new Search(id, slug, title, alternateTitles, generes, imdb, tmdb, desc, start, end, poster, voteAvg, voteCount);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Search)) {
            return false;
        }
        Search search = (Search) other;
        return this.id == search.id && Intrinsics.areEqual(this.slug, search.slug) && Intrinsics.areEqual(this.title, search.title) && Intrinsics.areEqual(this.alternateTitles, search.alternateTitles) && Intrinsics.areEqual(this.generes, search.generes) && Intrinsics.areEqual(this.imdb, search.imdb) && this.tmdb == search.tmdb && Intrinsics.areEqual(this.desc, search.desc) && this.start == search.start && Intrinsics.areEqual(this.end, search.end) && Intrinsics.areEqual(this.poster, search.poster) && Double.compare(this.voteAvg, search.voteAvg) == 0 && this.voteCount == search.voteCount;
    }

    public int hashCode() {
        return (((((((((((((((((((((((Search$$ExternalSyntheticBackport0.m12m(this.id) * 31) + this.slug.hashCode()) * 31) + this.title.hashCode()) * 31) + this.alternateTitles.hashCode()) * 31) + this.generes.hashCode()) * 31) + (this.imdb == null ? 0 : this.imdb.hashCode())) * 31) + Search$$ExternalSyntheticBackport0.m12m(this.tmdb)) * 31) + this.desc.hashCode()) * 31) + Search$$ExternalSyntheticBackport0.m12m(this.start)) * 31) + (this.end != null ? this.end.hashCode() : 0)) * 31) + this.poster.hashCode()) * 31) + Search$$ExternalSyntheticBackport1.m13m(this.voteAvg)) * 31) + Search$$ExternalSyntheticBackport0.m12m(this.voteCount);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Search(id=").append(this.id).append(", slug=").append(this.slug).append(", title=").append(this.title).append(", alternateTitles=").append(this.alternateTitles).append(", generes=").append(this.generes).append(", imdb=").append(this.imdb).append(", tmdb=").append(this.tmdb).append(", desc=").append(this.desc).append(", start=").append(this.start).append(", end=").append(this.end).append(", poster=").append(this.poster).append(", voteAvg=");
        sb.append(this.voteAvg).append(", voteCount=").append(this.voteCount).append(')');
        return sb.toString();
    }

    public Search(long id, @NotNull String slug, @NotNull String title, @NotNull String alternateTitles, @NotNull List<String> list, @Nullable String imdb, long tmdb, @NotNull String desc, long start, @Nullable Long end, @NotNull String poster, double voteAvg, long voteCount) {
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
}
