package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StremioC.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StremioX/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B×\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011\u0012\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017JÞ\u0001\u0010+\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00112\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013HÆ\u0001¢\u0006\u0002\u0010,J\u0014\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00100\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00101\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b!\u0010\u0017R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\"\u0010\u0017¨\u00062"}, d2 = {"Lcom/phisher98/Episodes;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "", "overview", "airDate", "air_date", "stillPath", "still_path", "voteAverage", "", "vote_average", "episodeNumber", "episode_number", "seasonNumber", "season_number", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getOverview", "getAirDate", "getStillPath", "getVoteAverage", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getEpisodeNumber", "getSeasonNumber", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/Episodes;", "equals", "", "other", "hashCode", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
    private final Integer seasonNumber;

    @Nullable
    private final String stillPath;

    @Nullable
    private final Double voteAverage;

    public Episodes() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ Episodes copy$default(Episodes episodes, Integer num, String str, String str2, String str3, String str4, Double d, Integer num2, Integer num3, int i, Object obj) {
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
        Integer num4 = num2;
        Integer num5 = num3;
        String str5 = str4;
        Double d2 = d;
        return episodes.copy(num, str, str2, str3, str5, d2, num4, num5);
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

    @NotNull
    public final Episodes copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("name") @Nullable String name, @JsonProperty("overview") @Nullable String overview, @JsonProperty("air_date") @Nullable String airDate, @JsonProperty("still_path") @Nullable String stillPath, @JsonProperty("vote_average") @Nullable Double voteAverage, @JsonProperty("episode_number") @Nullable Integer episodeNumber, @JsonProperty("season_number") @Nullable Integer seasonNumber) {
        return new Episodes(id, name, overview, airDate, stillPath, voteAverage, episodeNumber, seasonNumber);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Episodes)) {
            return false;
        }
        Episodes episodes = (Episodes) other;
        return Intrinsics.areEqual(this.id, episodes.id) && Intrinsics.areEqual(this.name, episodes.name) && Intrinsics.areEqual(this.overview, episodes.overview) && Intrinsics.areEqual(this.airDate, episodes.airDate) && Intrinsics.areEqual(this.stillPath, episodes.stillPath) && Intrinsics.areEqual(this.voteAverage, episodes.voteAverage) && Intrinsics.areEqual(this.episodeNumber, episodes.episodeNumber) && Intrinsics.areEqual(this.seasonNumber, episodes.seasonNumber);
    }

    public int hashCode() {
        return ((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.airDate == null ? 0 : this.airDate.hashCode())) * 31) + (this.stillPath == null ? 0 : this.stillPath.hashCode())) * 31) + (this.voteAverage == null ? 0 : this.voteAverage.hashCode())) * 31) + (this.episodeNumber == null ? 0 : this.episodeNumber.hashCode())) * 31) + (this.seasonNumber != null ? this.seasonNumber.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Episodes(id=" + this.id + ", name=" + this.name + ", overview=" + this.overview + ", airDate=" + this.airDate + ", stillPath=" + this.stillPath + ", voteAverage=" + this.voteAverage + ", episodeNumber=" + this.episodeNumber + ", seasonNumber=" + this.seasonNumber + ')';
    }

    public Episodes(@JsonProperty("id") @Nullable Integer id, @JsonProperty("name") @Nullable String name, @JsonProperty("overview") @Nullable String overview, @JsonProperty("air_date") @Nullable String airDate, @JsonProperty("still_path") @Nullable String stillPath, @JsonProperty("vote_average") @Nullable Double voteAverage, @JsonProperty("episode_number") @Nullable Integer episodeNumber, @JsonProperty("season_number") @Nullable Integer seasonNumber) {
        this.id = id;
        this.name = name;
        this.overview = overview;
        this.airDate = airDate;
        this.stillPath = stillPath;
        this.voteAverage = voteAverage;
        this.episodeNumber = episodeNumber;
        this.seasonNumber = seasonNumber;
    }

    public /* synthetic */ Episodes(Integer num, String str, String str2, String str3, String str4, Double d, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : d, (i & 64) != 0 ? null : num2, (i & 128) != 0 ? null : num3);
    }

    @Nullable
    public final Integer getId() {
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
    public final String getAirDate() {
        return this.airDate;
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
    public final Integer getEpisodeNumber() {
        return this.episodeNumber;
    }

    @Nullable
    public final Integer getSeasonNumber() {
        return this.seasonNumber;
    }
}
