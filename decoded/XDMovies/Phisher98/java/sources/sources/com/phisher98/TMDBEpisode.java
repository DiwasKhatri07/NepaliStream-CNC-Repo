package com.phisher98;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: XDMoviesParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/XDMovies/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BÇ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010&J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010F\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010&J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010 J\u0011\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014HÆ\u0003J\u0011\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0014HÆ\u0003JÎ\u0001\u0010L\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010MJ\u0014\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010Q\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010R\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR)\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\"¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R'\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b($¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR'\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(+¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010!\u001a\u0004\b,\u0010 R)\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(.¢\u0006\n\n\u0002\u0010!\u001a\u0004\b-\u0010 R)\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(0¢\u0006\n\n\u0002\u0010'\u001a\u0004\b/\u0010&R'\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(2¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001bR)\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004\u0092\u0002\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(6¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R)\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(8¢\u0006\n\n\u0002\u0010!\u001a\u0004\b7\u0010 R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R-\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00148\u0006X\u0087\u0004\u0092\u0002\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(<¢\u0006\b\n\u0000\u001a\u0004\b;\u0010:¨\u0006S"}, d2 = {"Lcom/phisher98/TMDBEpisode;", "", "airDate", "", "episodeNumber", "", "episodeType", "id", "", "name", "overview", "productionCode", "runtime", "seasonNumber", "showId", "stillPath", "voteAverage", "", "voteCount", "crew", "", "Lcom/phisher98/Crew;", "guestStars", "Lcom/phisher98/GuestStar;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)V", "getAirDate", "()Ljava/lang/String;", "Lcom/google/gson/annotations/SerializedName;", "value", "air_date", "getEpisodeNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "episode_number", "getEpisodeType", "episode_type", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getName", "getOverview", "getProductionCode", "production_code", "getRuntime", "getSeasonNumber", "season_number", "getShowId", "show_id", "getStillPath", "still_path", "getVoteAverage", "()Ljava/lang/Double;", "Ljava/lang/Double;", "vote_average", "getVoteCount", "vote_count", "getCrew", "()Ljava/util/List;", "getGuestStars", "guest_stars", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)Lcom/phisher98/TMDBEpisode;", "equals", "", "other", "hashCode", "toString", "XDMovies"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class TMDBEpisode {

    @SerializedName("air_date")
    @Nullable
    private final String airDate;

    @Nullable
    private final List<Crew> crew;

    @SerializedName("episode_number")
    @Nullable
    private final Integer episodeNumber;

    @SerializedName("episode_type")
    @Nullable
    private final String episodeType;

    @SerializedName("guest_stars")
    @Nullable
    private final List<GuestStar> guestStars;

    @Nullable
    private final Long id;

    @Nullable
    private final String name;

    @Nullable
    private final String overview;

    @SerializedName("production_code")
    @Nullable
    private final String productionCode;

    @Nullable
    private final Integer runtime;

    @SerializedName("season_number")
    @Nullable
    private final Integer seasonNumber;

    @SerializedName("show_id")
    @Nullable
    private final Long showId;

    @SerializedName("still_path")
    @Nullable
    private final String stillPath;

    @SerializedName("vote_average")
    @Nullable
    private final Double voteAverage;

    @SerializedName("vote_count")
    @Nullable
    private final Integer voteCount;

    public TMDBEpisode() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAirDate() {
        return this.airDate;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Long getShowId() {
        return this.showId;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getStillPath() {
        return this.stillPath;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Double getVoteAverage() {
        return this.voteAverage;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Integer getVoteCount() {
        return this.voteCount;
    }

    @Nullable
    public final List<Crew> component14() {
        return this.crew;
    }

    @Nullable
    public final List<GuestStar> component15() {
        return this.guestStars;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getEpisodeNumber() {
        return this.episodeNumber;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getEpisodeType() {
        return this.episodeType;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getProductionCode() {
        return this.productionCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getRuntime() {
        return this.runtime;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getSeasonNumber() {
        return this.seasonNumber;
    }

    @NotNull
    public final TMDBEpisode copy(@Nullable String airDate, @Nullable Integer episodeNumber, @Nullable String episodeType, @Nullable Long id, @Nullable String name, @Nullable String overview, @Nullable String productionCode, @Nullable Integer runtime, @Nullable Integer seasonNumber, @Nullable Long showId, @Nullable String stillPath, @Nullable Double voteAverage, @Nullable Integer voteCount, @Nullable List<Crew> crew, @Nullable List<GuestStar> guestStars) {
        return new TMDBEpisode(airDate, episodeNumber, episodeType, id, name, overview, productionCode, runtime, seasonNumber, showId, stillPath, voteAverage, voteCount, crew, guestStars);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TMDBEpisode)) {
            return false;
        }
        TMDBEpisode tMDBEpisode = (TMDBEpisode) other;
        return Intrinsics.areEqual(this.airDate, tMDBEpisode.airDate) && Intrinsics.areEqual(this.episodeNumber, tMDBEpisode.episodeNumber) && Intrinsics.areEqual(this.episodeType, tMDBEpisode.episodeType) && Intrinsics.areEqual(this.id, tMDBEpisode.id) && Intrinsics.areEqual(this.name, tMDBEpisode.name) && Intrinsics.areEqual(this.overview, tMDBEpisode.overview) && Intrinsics.areEqual(this.productionCode, tMDBEpisode.productionCode) && Intrinsics.areEqual(this.runtime, tMDBEpisode.runtime) && Intrinsics.areEqual(this.seasonNumber, tMDBEpisode.seasonNumber) && Intrinsics.areEqual(this.showId, tMDBEpisode.showId) && Intrinsics.areEqual(this.stillPath, tMDBEpisode.stillPath) && Intrinsics.areEqual(this.voteAverage, tMDBEpisode.voteAverage) && Intrinsics.areEqual(this.voteCount, tMDBEpisode.voteCount) && Intrinsics.areEqual(this.crew, tMDBEpisode.crew) && Intrinsics.areEqual(this.guestStars, tMDBEpisode.guestStars);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((this.airDate == null ? 0 : this.airDate.hashCode()) * 31) + (this.episodeNumber == null ? 0 : this.episodeNumber.hashCode())) * 31) + (this.episodeType == null ? 0 : this.episodeType.hashCode())) * 31) + (this.id == null ? 0 : this.id.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.productionCode == null ? 0 : this.productionCode.hashCode())) * 31) + (this.runtime == null ? 0 : this.runtime.hashCode())) * 31) + (this.seasonNumber == null ? 0 : this.seasonNumber.hashCode())) * 31) + (this.showId == null ? 0 : this.showId.hashCode())) * 31) + (this.stillPath == null ? 0 : this.stillPath.hashCode())) * 31) + (this.voteAverage == null ? 0 : this.voteAverage.hashCode())) * 31) + (this.voteCount == null ? 0 : this.voteCount.hashCode())) * 31) + (this.crew == null ? 0 : this.crew.hashCode())) * 31) + (this.guestStars != null ? this.guestStars.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TMDBEpisode(airDate=").append(this.airDate).append(", episodeNumber=").append(this.episodeNumber).append(", episodeType=").append(this.episodeType).append(", id=").append(this.id).append(", name=").append(this.name).append(", overview=").append(this.overview).append(", productionCode=").append(this.productionCode).append(", runtime=").append(this.runtime).append(", seasonNumber=").append(this.seasonNumber).append(", showId=").append(this.showId).append(", stillPath=").append(this.stillPath).append(", voteAverage=");
        sb.append(this.voteAverage).append(", voteCount=").append(this.voteCount).append(", crew=").append(this.crew).append(", guestStars=").append(this.guestStars).append(')');
        return sb.toString();
    }

    public TMDBEpisode(@Nullable String airDate, @Nullable Integer episodeNumber, @Nullable String episodeType, @Nullable Long id, @Nullable String name, @Nullable String overview, @Nullable String productionCode, @Nullable Integer runtime, @Nullable Integer seasonNumber, @Nullable Long showId, @Nullable String stillPath, @Nullable Double voteAverage, @Nullable Integer voteCount, @Nullable List<Crew> list, @Nullable List<GuestStar> list2) {
        this.airDate = airDate;
        this.episodeNumber = episodeNumber;
        this.episodeType = episodeType;
        this.id = id;
        this.name = name;
        this.overview = overview;
        this.productionCode = productionCode;
        this.runtime = runtime;
        this.seasonNumber = seasonNumber;
        this.showId = showId;
        this.stillPath = stillPath;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.crew = list;
        this.guestStars = list2;
    }

    public /* synthetic */ TMDBEpisode(String str, Integer num, String str2, Long l, String str3, String str4, String str5, Integer num2, Integer num3, Long l2, String str6, Double d, Integer num4, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : num2, (i & 256) != 0 ? null : num3, (i & 512) != 0 ? null : l2, (i & 1024) != 0 ? null : str6, (i & 2048) != 0 ? null : d, (i & 4096) != 0 ? null : num4, (i & 8192) != 0 ? null : list, (i & 16384) == 0 ? list2 : null);
    }

    @Nullable
    public final String getAirDate() {
        return this.airDate;
    }

    @Nullable
    public final Integer getEpisodeNumber() {
        return this.episodeNumber;
    }

    @Nullable
    public final String getEpisodeType() {
        return this.episodeType;
    }

    @Nullable
    public final Long getId() {
        return this.id;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    public final String getProductionCode() {
        return this.productionCode;
    }

    @Nullable
    public final Integer getRuntime() {
        return this.runtime;
    }

    @Nullable
    public final Integer getSeasonNumber() {
        return this.seasonNumber;
    }

    @Nullable
    public final Long getShowId() {
        return this.showId;
    }

    @Nullable
    public final String getStillPath() {
        return this.stillPath;
    }

    @Nullable
    public final Double getVoteAverage() {
        return this.voteAverage;
    }

    @Nullable
    public final Integer getVoteCount() {
        return this.voteCount;
    }

    @Nullable
    public final List<Crew> getCrew() {
        return this.crew;
    }

    @Nullable
    public final List<GuestStar> getGuestStars() {
        return this.guestStars;
    }
}
