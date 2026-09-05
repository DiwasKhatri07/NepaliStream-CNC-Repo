package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJv\u0010\u0015\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\bHÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/phisher98/WatchsomuchTorrents;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "movieId", "season", "episode", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMovieId", "getSeason", "getEpisode", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/WatchsomuchTorrents;", "equals", "", "other", "hashCode", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class WatchsomuchTorrents {

    @Nullable
    private final Integer episode;

    @Nullable
    private final Integer id;

    @Nullable
    private final Integer movieId;

    @Nullable
    private final Integer season;

    public WatchsomuchTorrents() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ WatchsomuchTorrents copy$default(WatchsomuchTorrents watchsomuchTorrents, Integer num, Integer num2, Integer num3, Integer num4, int i, Object obj) {
        if ((i & 1) != 0) {
            num = watchsomuchTorrents.id;
        }
        if ((i & 2) != 0) {
            num2 = watchsomuchTorrents.movieId;
        }
        if ((i & 4) != 0) {
            num3 = watchsomuchTorrents.season;
        }
        if ((i & 8) != 0) {
            num4 = watchsomuchTorrents.episode;
        }
        return watchsomuchTorrents.copy(num, num2, num3, num4);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getMovieId() {
        return this.movieId;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getSeason() {
        return this.season;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getEpisode() {
        return this.episode;
    }

    @NotNull
    public final WatchsomuchTorrents copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("movieId") @Nullable Integer movieId, @JsonProperty("season") @Nullable Integer season, @JsonProperty("episode") @Nullable Integer episode) {
        return new WatchsomuchTorrents(id, movieId, season, episode);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WatchsomuchTorrents)) {
            return false;
        }
        WatchsomuchTorrents watchsomuchTorrents = (WatchsomuchTorrents) other;
        return Intrinsics.areEqual(this.id, watchsomuchTorrents.id) && Intrinsics.areEqual(this.movieId, watchsomuchTorrents.movieId) && Intrinsics.areEqual(this.season, watchsomuchTorrents.season) && Intrinsics.areEqual(this.episode, watchsomuchTorrents.episode);
    }

    public int hashCode() {
        return ((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.movieId == null ? 0 : this.movieId.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episode != null ? this.episode.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "WatchsomuchTorrents(id=" + this.id + ", movieId=" + this.movieId + ", season=" + this.season + ", episode=" + this.episode + ')';
    }

    public WatchsomuchTorrents(@JsonProperty("id") @Nullable Integer id, @JsonProperty("movieId") @Nullable Integer movieId, @JsonProperty("season") @Nullable Integer season, @JsonProperty("episode") @Nullable Integer episode) {
        this.id = id;
        this.movieId = movieId;
        this.season = season;
        this.episode = episode;
    }

    public /* synthetic */ WatchsomuchTorrents(Integer num, Integer num2, Integer num3, Integer num4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4);
    }

    @Nullable
    public final Integer getId() {
        return this.id;
    }

    @Nullable
    public final Integer getMovieId() {
        return this.movieId;
    }

    @Nullable
    public final Integer getSeason() {
        return this.season;
    }

    @Nullable
    public final Integer getEpisode() {
        return this.episode;
    }
}
