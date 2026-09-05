package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TorraStreamParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/TorraStream/classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011Jz\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00100J\u0014\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00104\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00105\u001a\u00020\u0005HÖ\u0081\u0004R%\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007z\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0007z\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R#\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0007z\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R#\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0007z\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R#\u0010\b\u001a\u0004\u0018\u00010\u00058\u0007z\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R%\u0010\t\u001a\u0004\u0018\u00010\n8\u0007z\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001f¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR%\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0007z\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(!¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b \u0010\u0011R%\u0010\f\u001a\u0004\u0018\u00010\u00038\u0007z\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(#¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\"\u0010\u0011R%\u0010\r\u001a\u0004\u0018\u00010\u00038\u0007z\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(%¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b$\u0010\u0011¨\u00066"}, d2 = {"Lcom/phisher98/Episodes;", "", "id", "", "name", "", "overview", "airDate", "stillPath", "voteAverage", "", "episodeNumber", "seasonNumber", "runTime", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "getName", "()Ljava/lang/String;", "getOverview", "getAirDate", "air_date", "getStillPath", "still_path", "getVoteAverage", "()Ljava/lang/Double;", "Ljava/lang/Double;", "vote_average", "getEpisodeNumber", "episode_number", "getSeasonNumber", "season_number", "getRunTime", "runtime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/Episodes;", "equals", "", "other", "hashCode", "toString", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Episodes {

    @Nullable
    private final String airDate;

    @Nullable
    private final Integer episodeNumber;

    @Nullable
    private final Integer id;

    @Nullable
    private final String name;

    @Nullable
    private final String overview;

    @Nullable
    private final Integer runTime;

    @Nullable
    private final Integer seasonNumber;

    @Nullable
    private final String stillPath;

    @Nullable
    private final Double voteAverage;

    public Episodes() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ Episodes copy$default(Episodes episodes, Integer num, String str, String str2, String str3, String str4, Double d, Integer num2, Integer num3, Integer num4, int i, Object obj) {
        if ((i & 1) != 0) {
            num = episodes.id;
        }
        if ((i & 2) != 0) {
            str = episodes.name;
        }
        if ((i & 4) != 0) {
            str2 = episodes.overview;
        }
        if ((i & 8) != 0) {
            str3 = episodes.airDate;
        }
        if ((i & 16) != 0) {
            str4 = episodes.stillPath;
        }
        if ((i & 32) != 0) {
            d = episodes.voteAverage;
        }
        if ((i & 64) != 0) {
            num2 = episodes.episodeNumber;
        }
        if ((i & 128) != 0) {
            num3 = episodes.seasonNumber;
        }
        if ((i & 256) != 0) {
            num4 = episodes.runTime;
        }
        Integer num5 = num3;
        Integer num6 = num4;
        Double d2 = d;
        Integer num7 = num2;
        String str5 = str4;
        String str6 = str2;
        return episodes.copy(num, str, str6, str3, str5, d2, num7, num5, num6);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAirDate() {
        return this.airDate;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStillPath() {
        return this.stillPath;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Double getVoteAverage() {
        return this.voteAverage;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getEpisodeNumber() {
        return this.episodeNumber;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getSeasonNumber() {
        return this.seasonNumber;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getRunTime() {
        return this.runTime;
    }

    @NotNull
    public final Episodes copy(@Nullable Integer id, @Nullable String name, @Nullable String overview, @Nullable String airDate, @Nullable String stillPath, @Nullable Double voteAverage, @Nullable Integer episodeNumber, @Nullable Integer seasonNumber, @Nullable Integer runTime) {
        return new Episodes(id, name, overview, airDate, stillPath, voteAverage, episodeNumber, seasonNumber, runTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Episodes)) {
            return false;
        }
        Episodes episodes = (Episodes) other;
        return Intrinsics.areEqual(this.id, episodes.id) && Intrinsics.areEqual(this.name, episodes.name) && Intrinsics.areEqual(this.overview, episodes.overview) && Intrinsics.areEqual(this.airDate, episodes.airDate) && Intrinsics.areEqual(this.stillPath, episodes.stillPath) && Intrinsics.areEqual(this.voteAverage, episodes.voteAverage) && Intrinsics.areEqual(this.episodeNumber, episodes.episodeNumber) && Intrinsics.areEqual(this.seasonNumber, episodes.seasonNumber) && Intrinsics.areEqual(this.runTime, episodes.runTime);
    }

    public int hashCode() {
        return ((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.airDate == null ? 0 : this.airDate.hashCode())) * 31) + (this.stillPath == null ? 0 : this.stillPath.hashCode())) * 31) + (this.voteAverage == null ? 0 : this.voteAverage.hashCode())) * 31) + (this.episodeNumber == null ? 0 : this.episodeNumber.hashCode())) * 31) + (this.seasonNumber == null ? 0 : this.seasonNumber.hashCode())) * 31) + (this.runTime != null ? this.runTime.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Episodes(id=" + this.id + ", name=" + this.name + ", overview=" + this.overview + ", airDate=" + this.airDate + ", stillPath=" + this.stillPath + ", voteAverage=" + this.voteAverage + ", episodeNumber=" + this.episodeNumber + ", seasonNumber=" + this.seasonNumber + ", runTime=" + this.runTime + ')';
    }

    public Episodes(@Nullable Integer id, @Nullable String name, @Nullable String overview, @Nullable String airDate, @Nullable String stillPath, @Nullable Double voteAverage, @Nullable Integer episodeNumber, @Nullable Integer seasonNumber, @Nullable Integer runTime) {
        this.id = id;
        this.name = name;
        this.overview = overview;
        this.airDate = airDate;
        this.stillPath = stillPath;
        this.voteAverage = voteAverage;
        this.episodeNumber = episodeNumber;
        this.seasonNumber = seasonNumber;
        this.runTime = runTime;
    }

    public /* synthetic */ Episodes(Integer num, String str, String str2, String str3, String str4, Double d, Integer num2, Integer num3, Integer num4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : d, (i & 64) != 0 ? null : num2, (i & 128) != 0 ? null : num3, (i & 256) != 0 ? null : num4);
    }

    @JsonProperty("id")
    @Nullable
    public final Integer getId() {
        return this.id;
    }

    @JsonProperty("name")
    @Nullable
    public final String getName() {
        return this.name;
    }

    @JsonProperty("overview")
    @Nullable
    public final String getOverview() {
        return this.overview;
    }

    @JsonProperty("air_date")
    @Nullable
    public final String getAirDate() {
        return this.airDate;
    }

    @JsonProperty("still_path")
    @Nullable
    public final String getStillPath() {
        return this.stillPath;
    }

    @JsonProperty("vote_average")
    @Nullable
    public final Double getVoteAverage() {
        return this.voteAverage;
    }

    @JsonProperty("episode_number")
    @Nullable
    public final Integer getEpisodeNumber() {
        return this.episodeNumber;
    }

    @JsonProperty("season_number")
    @Nullable
    public final Integer getSeasonNumber() {
        return this.seasonNumber;
    }

    @JsonProperty("runtime")
    @Nullable
    public final Integer getRunTime() {
        return this.runTime;
    }
}
