package com.phisher98;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: XDMoviesParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/XDMovies/classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00100\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00102\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u00107\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010+J\u0092\u0001\u00108\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u00109J\u0014\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010=\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010>\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R'\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R)\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u0092\u0002\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0002¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R'\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(%¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R)\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u0092\u0002\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b()¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R)\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004\u0092\u0002\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(-¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+¨\u0006?"}, d2 = {"Lcom/phisher98/TMDBRes;", "", "id", "", "airDate", "episodes", "", "Lcom/phisher98/TMDBEpisode;", "name", "networks", "Lcom/phisher98/Network;", "overview", "id2", "", "posterPath", "seasonNumber", "", "voteAverage", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;)V", "getId", "()Ljava/lang/String;", "Lcom/google/gson/annotations/SerializedName;", "value", "_id", "getAirDate", "air_date", "getEpisodes", "()Ljava/util/List;", "getName", "getNetworks", "getOverview", "getId2", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPosterPath", "poster_path", "getSeasonNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "season_number", "getVoteAverage", "()Ljava/lang/Double;", "Ljava/lang/Double;", "vote_average", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;)Lcom/phisher98/TMDBRes;", "equals", "", "other", "hashCode", "toString", "XDMovies"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class TMDBRes {

    @SerializedName("air_date")
    @Nullable
    private final String airDate;

    @Nullable
    private final List<TMDBEpisode> episodes;

    @SerializedName("_id")
    @Nullable
    private final String id;

    @SerializedName("id")
    @Nullable
    private final Long id2;

    @Nullable
    private final String name;

    @Nullable
    private final List<Network> networks;

    @Nullable
    private final String overview;

    @SerializedName("poster_path")
    @Nullable
    private final String posterPath;

    @SerializedName("season_number")
    @Nullable
    private final Integer seasonNumber;

    @SerializedName("vote_average")
    @Nullable
    private final Double voteAverage;

    public TMDBRes() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TMDBRes copy$default(TMDBRes tMDBRes, String str, String str2, List list, String str3, List list2, String str4, Long l, String str5, Integer num, Double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tMDBRes.id;
        }
        if ((i & 2) != 0) {
            str2 = tMDBRes.airDate;
        }
        if ((i & 4) != 0) {
            list = tMDBRes.episodes;
        }
        if ((i & 8) != 0) {
            str3 = tMDBRes.name;
        }
        if ((i & 16) != 0) {
            list2 = tMDBRes.networks;
        }
        if ((i & 32) != 0) {
            str4 = tMDBRes.overview;
        }
        if ((i & 64) != 0) {
            l = tMDBRes.id2;
        }
        if ((i & 128) != 0) {
            str5 = tMDBRes.posterPath;
        }
        if ((i & 256) != 0) {
            num = tMDBRes.seasonNumber;
        }
        if ((i & 512) != 0) {
            d = tMDBRes.voteAverage;
        }
        Integer num2 = num;
        Double d2 = d;
        Long l2 = l;
        String str6 = str5;
        List list3 = list2;
        String str7 = str4;
        return tMDBRes.copy(str, str2, list, str3, list3, str7, l2, str6, num2, d2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Double getVoteAverage() {
        return this.voteAverage;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAirDate() {
        return this.airDate;
    }

    @Nullable
    public final List<TMDBEpisode> component3() {
        return this.episodes;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final List<Network> component5() {
        return this.networks;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Long getId2() {
        return this.id2;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getPosterPath() {
        return this.posterPath;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getSeasonNumber() {
        return this.seasonNumber;
    }

    @NotNull
    public final TMDBRes copy(@Nullable String id, @Nullable String airDate, @Nullable List<TMDBEpisode> episodes, @Nullable String name, @Nullable List<Network> networks, @Nullable String overview, @Nullable Long id2, @Nullable String posterPath, @Nullable Integer seasonNumber, @Nullable Double voteAverage) {
        return new TMDBRes(id, airDate, episodes, name, networks, overview, id2, posterPath, seasonNumber, voteAverage);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TMDBRes)) {
            return false;
        }
        TMDBRes tMDBRes = (TMDBRes) other;
        return Intrinsics.areEqual(this.id, tMDBRes.id) && Intrinsics.areEqual(this.airDate, tMDBRes.airDate) && Intrinsics.areEqual(this.episodes, tMDBRes.episodes) && Intrinsics.areEqual(this.name, tMDBRes.name) && Intrinsics.areEqual(this.networks, tMDBRes.networks) && Intrinsics.areEqual(this.overview, tMDBRes.overview) && Intrinsics.areEqual(this.id2, tMDBRes.id2) && Intrinsics.areEqual(this.posterPath, tMDBRes.posterPath) && Intrinsics.areEqual(this.seasonNumber, tMDBRes.seasonNumber) && Intrinsics.areEqual(this.voteAverage, tMDBRes.voteAverage);
    }

    public int hashCode() {
        return ((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.airDate == null ? 0 : this.airDate.hashCode())) * 31) + (this.episodes == null ? 0 : this.episodes.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.networks == null ? 0 : this.networks.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.id2 == null ? 0 : this.id2.hashCode())) * 31) + (this.posterPath == null ? 0 : this.posterPath.hashCode())) * 31) + (this.seasonNumber == null ? 0 : this.seasonNumber.hashCode())) * 31) + (this.voteAverage != null ? this.voteAverage.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "TMDBRes(id=" + this.id + ", airDate=" + this.airDate + ", episodes=" + this.episodes + ", name=" + this.name + ", networks=" + this.networks + ", overview=" + this.overview + ", id2=" + this.id2 + ", posterPath=" + this.posterPath + ", seasonNumber=" + this.seasonNumber + ", voteAverage=" + this.voteAverage + ')';
    }

    public TMDBRes(@Nullable String id, @Nullable String airDate, @Nullable List<TMDBEpisode> list, @Nullable String name, @Nullable List<Network> list2, @Nullable String overview, @Nullable Long id2, @Nullable String posterPath, @Nullable Integer seasonNumber, @Nullable Double voteAverage) {
        this.id = id;
        this.airDate = airDate;
        this.episodes = list;
        this.name = name;
        this.networks = list2;
        this.overview = overview;
        this.id2 = id2;
        this.posterPath = posterPath;
        this.seasonNumber = seasonNumber;
        this.voteAverage = voteAverage;
    }

    public /* synthetic */ TMDBRes(String str, String str2, List list, String str3, List list2, String str4, Long l, String str5, Integer num, Double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : list2, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : l, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : num, (i & 512) != 0 ? null : d);
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getAirDate() {
        return this.airDate;
    }

    @Nullable
    public final List<TMDBEpisode> getEpisodes() {
        return this.episodes;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final List<Network> getNetworks() {
        return this.networks;
    }

    @Nullable
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    public final Long getId2() {
        return this.id2;
    }

    @Nullable
    public final String getPosterPath() {
        return this.posterPath;
    }

    @Nullable
    public final Integer getSeasonNumber() {
        return this.seasonNumber;
    }

    @Nullable
    public final Double getVoteAverage() {
        return this.voteAverage;
    }
}
