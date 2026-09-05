package com.hindmoviez;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Hindmoviez/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0018Jb\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\"J\u0014\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010&\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010'\u001a\u00020\u0006HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/hindmoviez/TmdbEpisode;", "", "episode_number", "", "season_number", "name", "", "overview", "still_path", "air_date", "vote_average", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)V", "getEpisode_number", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSeason_number", "getName", "()Ljava/lang/String;", "getOverview", "getStill_path", "getAir_date", "getVote_average", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)Lcom/hindmoviez/TmdbEpisode;", "equals", "", "other", "hashCode", "toString", "Hindmoviez"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class TmdbEpisode {

    @Nullable
    private final String air_date;

    @Nullable
    private final Integer episode_number;

    @Nullable
    private final String name;

    @Nullable
    private final String overview;

    @Nullable
    private final Integer season_number;

    @Nullable
    private final String still_path;

    @Nullable
    private final Double vote_average;

    public TmdbEpisode() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ TmdbEpisode copy$default(TmdbEpisode tmdbEpisode, Integer num, Integer num2, String str, String str2, String str3, String str4, Double d, int i, Object obj) {
        if ((i & 1) != 0) {
            num = tmdbEpisode.episode_number;
        }
        if ((i & 2) != 0) {
            num2 = tmdbEpisode.season_number;
        }
        if ((i & 4) != 0) {
            str = tmdbEpisode.name;
        }
        if ((i & 8) != 0) {
            str2 = tmdbEpisode.overview;
        }
        if ((i & 16) != 0) {
            str3 = tmdbEpisode.still_path;
        }
        if ((i & 32) != 0) {
            str4 = tmdbEpisode.air_date;
        }
        if ((i & 64) != 0) {
            d = tmdbEpisode.vote_average;
        }
        String str5 = str4;
        Double d2 = d;
        String str6 = str3;
        String str7 = str;
        return tmdbEpisode.copy(num, num2, str7, str2, str6, str5, d2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getEpisode_number() {
        return this.episode_number;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getSeason_number() {
        return this.season_number;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStill_path() {
        return this.still_path;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getAir_date() {
        return this.air_date;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Double getVote_average() {
        return this.vote_average;
    }

    @NotNull
    public final TmdbEpisode copy(@Nullable Integer episode_number, @Nullable Integer season_number, @Nullable String name, @Nullable String overview, @Nullable String still_path, @Nullable String air_date, @Nullable Double vote_average) {
        return new TmdbEpisode(episode_number, season_number, name, overview, still_path, air_date, vote_average);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TmdbEpisode)) {
            return false;
        }
        TmdbEpisode tmdbEpisode = (TmdbEpisode) other;
        return Intrinsics.areEqual(this.episode_number, tmdbEpisode.episode_number) && Intrinsics.areEqual(this.season_number, tmdbEpisode.season_number) && Intrinsics.areEqual(this.name, tmdbEpisode.name) && Intrinsics.areEqual(this.overview, tmdbEpisode.overview) && Intrinsics.areEqual(this.still_path, tmdbEpisode.still_path) && Intrinsics.areEqual(this.air_date, tmdbEpisode.air_date) && Intrinsics.areEqual(this.vote_average, tmdbEpisode.vote_average);
    }

    public int hashCode() {
        return ((((((((((((this.episode_number == null ? 0 : this.episode_number.hashCode()) * 31) + (this.season_number == null ? 0 : this.season_number.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.still_path == null ? 0 : this.still_path.hashCode())) * 31) + (this.air_date == null ? 0 : this.air_date.hashCode())) * 31) + (this.vote_average != null ? this.vote_average.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "TmdbEpisode(episode_number=" + this.episode_number + ", season_number=" + this.season_number + ", name=" + this.name + ", overview=" + this.overview + ", still_path=" + this.still_path + ", air_date=" + this.air_date + ", vote_average=" + this.vote_average + ')';
    }

    public TmdbEpisode(@Nullable Integer episode_number, @Nullable Integer season_number, @Nullable String name, @Nullable String overview, @Nullable String still_path, @Nullable String air_date, @Nullable Double vote_average) {
        this.episode_number = episode_number;
        this.season_number = season_number;
        this.name = name;
        this.overview = overview;
        this.still_path = still_path;
        this.air_date = air_date;
        this.vote_average = vote_average;
    }

    public /* synthetic */ TmdbEpisode(Integer num, Integer num2, String str, String str2, String str3, String str4, Double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : d);
    }

    @Nullable
    public final Integer getEpisode_number() {
        return this.episode_number;
    }

    @Nullable
    public final Integer getSeason_number() {
        return this.season_number;
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
    public final String getStill_path() {
        return this.still_path;
    }

    @Nullable
    public final String getAir_date() {
        return this.air_date;
    }

    @Nullable
    public final Double getVote_average() {
        return this.vote_average;
    }
}
