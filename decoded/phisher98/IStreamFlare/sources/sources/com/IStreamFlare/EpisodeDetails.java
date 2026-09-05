package com.IStreamFlare;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IStreamFlareParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/IStreamFlare/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014Jz\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010%J\u0014\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010)\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010*\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001a\u0010\u0014¨\u0006+"}, d2 = {"Lcom/IStreamFlare/EpisodeDetails;", "", "id", "", "name", "title", "season", "", "episode", "released", "overview", "thumbnail", "moviedb_id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/String;", "getName", "getTitle", "getSeason", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEpisode", "getReleased", "getOverview", "getThumbnail", "getMoviedb_id", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/IStreamFlare/EpisodeDetails;", "equals", "", "other", "hashCode", "toString", "IStreamFlare"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class EpisodeDetails {

    @Nullable
    private final Integer episode;

    @Nullable
    private final String id;

    @Nullable
    private final Integer moviedb_id;

    @Nullable
    private final String name;

    @Nullable
    private final String overview;

    @Nullable
    private final String released;

    @Nullable
    private final Integer season;

    @Nullable
    private final String thumbnail;

    @Nullable
    private final String title;

    public static /* synthetic */ EpisodeDetails copy$default(EpisodeDetails episodeDetails, String str, String str2, String str3, Integer num, Integer num2, String str4, String str5, String str6, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = episodeDetails.id;
        }
        if ((i & 2) != 0) {
            str2 = episodeDetails.name;
        }
        if ((i & 4) != 0) {
            str3 = episodeDetails.title;
        }
        if ((i & 8) != 0) {
            num = episodeDetails.season;
        }
        if ((i & 16) != 0) {
            num2 = episodeDetails.episode;
        }
        if ((i & 32) != 0) {
            str4 = episodeDetails.released;
        }
        if ((i & 64) != 0) {
            str5 = episodeDetails.overview;
        }
        if ((i & 128) != 0) {
            str6 = episodeDetails.thumbnail;
        }
        if ((i & 256) != 0) {
            num3 = episodeDetails.moviedb_id;
        }
        String str7 = str6;
        Integer num4 = num3;
        String str8 = str4;
        String str9 = str5;
        Integer num5 = num2;
        String str10 = str3;
        return episodeDetails.copy(str, str2, str10, num, num5, str8, str9, str7, num4);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getSeason() {
        return this.season;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getEpisode() {
        return this.episode;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getReleased() {
        return this.released;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getThumbnail() {
        return this.thumbnail;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getMoviedb_id() {
        return this.moviedb_id;
    }

    @NotNull
    public final EpisodeDetails copy(@Nullable String id, @Nullable String name, @Nullable String title, @Nullable Integer season, @Nullable Integer episode, @Nullable String released, @Nullable String overview, @Nullable String thumbnail, @Nullable Integer moviedb_id) {
        return new EpisodeDetails(id, name, title, season, episode, released, overview, thumbnail, moviedb_id);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EpisodeDetails)) {
            return false;
        }
        EpisodeDetails episodeDetails = (EpisodeDetails) other;
        return Intrinsics.areEqual(this.id, episodeDetails.id) && Intrinsics.areEqual(this.name, episodeDetails.name) && Intrinsics.areEqual(this.title, episodeDetails.title) && Intrinsics.areEqual(this.season, episodeDetails.season) && Intrinsics.areEqual(this.episode, episodeDetails.episode) && Intrinsics.areEqual(this.released, episodeDetails.released) && Intrinsics.areEqual(this.overview, episodeDetails.overview) && Intrinsics.areEqual(this.thumbnail, episodeDetails.thumbnail) && Intrinsics.areEqual(this.moviedb_id, episodeDetails.moviedb_id);
    }

    public int hashCode() {
        return ((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episode == null ? 0 : this.episode.hashCode())) * 31) + (this.released == null ? 0 : this.released.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.thumbnail == null ? 0 : this.thumbnail.hashCode())) * 31) + (this.moviedb_id != null ? this.moviedb_id.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "EpisodeDetails(id=" + this.id + ", name=" + this.name + ", title=" + this.title + ", season=" + this.season + ", episode=" + this.episode + ", released=" + this.released + ", overview=" + this.overview + ", thumbnail=" + this.thumbnail + ", moviedb_id=" + this.moviedb_id + ')';
    }

    public EpisodeDetails(@Nullable String id, @Nullable String name, @Nullable String title, @Nullable Integer season, @Nullable Integer episode, @Nullable String released, @Nullable String overview, @Nullable String thumbnail, @Nullable Integer moviedb_id) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.season = season;
        this.episode = episode;
        this.released = released;
        this.overview = overview;
        this.thumbnail = thumbnail;
        this.moviedb_id = moviedb_id;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
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
    public final String getReleased() {
        return this.released;
    }

    @Nullable
    public final String getOverview() {
        return this.overview;
    }

    @Nullable
    public final String getThumbnail() {
        return this.thumbnail;
    }

    @Nullable
    public final Integer getMoviedb_id() {
        return this.moviedb_id;
    }
}
