package com.Kartoons;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KartoonsParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Kartoons/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J*\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/Kartoons/SeasonEpisodes;", "", "seasonNumber", "", "episodes", "", "Lcom/Kartoons/EpisodeItem;", "<init>", "(Ljava/lang/Long;Ljava/util/List;)V", "getSeasonNumber", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEpisodes", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/util/List;)Lcom/Kartoons/SeasonEpisodes;", "equals", "", "other", "hashCode", "", "toString", "", "Kartoons"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class SeasonEpisodes {

    @NotNull
    private final List<EpisodeItem> episodes;

    @Nullable
    private final Long seasonNumber;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SeasonEpisodes copy$default(SeasonEpisodes seasonEpisodes, Long l, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            l = seasonEpisodes.seasonNumber;
        }
        if ((i & 2) != 0) {
            list = seasonEpisodes.episodes;
        }
        return seasonEpisodes.copy(l, list);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getSeasonNumber() {
        return this.seasonNumber;
    }

    @NotNull
    public final List<EpisodeItem> component2() {
        return this.episodes;
    }

    @NotNull
    public final SeasonEpisodes copy(@Nullable Long seasonNumber, @NotNull List<EpisodeItem> episodes) {
        return new SeasonEpisodes(seasonNumber, episodes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SeasonEpisodes)) {
            return false;
        }
        SeasonEpisodes seasonEpisodes = (SeasonEpisodes) other;
        return Intrinsics.areEqual(this.seasonNumber, seasonEpisodes.seasonNumber) && Intrinsics.areEqual(this.episodes, seasonEpisodes.episodes);
    }

    public int hashCode() {
        return ((this.seasonNumber == null ? 0 : this.seasonNumber.hashCode()) * 31) + this.episodes.hashCode();
    }

    @NotNull
    public String toString() {
        return "SeasonEpisodes(seasonNumber=" + this.seasonNumber + ", episodes=" + this.episodes + ')';
    }

    public SeasonEpisodes(@Nullable Long seasonNumber, @NotNull List<EpisodeItem> list) {
        this.seasonNumber = seasonNumber;
        this.episodes = list;
    }

    @Nullable
    public final Long getSeasonNumber() {
        return this.seasonNumber;
    }

    @NotNull
    public final List<EpisodeItem> getEpisodes() {
        return this.episodes;
    }
}
