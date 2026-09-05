package com.Fibwatch;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Fibwatch/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/Fibwatch/EpisodesResponse;", "", "status", "", "episodes", "", "Lcom/Fibwatch/EpisodeItem;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getStatus", "()Ljava/lang/String;", "getEpisodes", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Fibwatch"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class EpisodesResponse {

    @Nullable
    private final List<EpisodeItem> episodes;

    @Nullable
    private final String status;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EpisodesResponse copy$default(EpisodesResponse episodesResponse, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = episodesResponse.status;
        }
        if ((i & 2) != 0) {
            list = episodesResponse.episodes;
        }
        return episodesResponse.copy(str, list);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final List<EpisodeItem> component2() {
        return this.episodes;
    }

    @NotNull
    public final EpisodesResponse copy(@Nullable String status, @Nullable List<EpisodeItem> episodes) {
        return new EpisodesResponse(status, episodes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EpisodesResponse)) {
            return false;
        }
        EpisodesResponse episodesResponse = (EpisodesResponse) other;
        return Intrinsics.areEqual(this.status, episodesResponse.status) && Intrinsics.areEqual(this.episodes, episodesResponse.episodes);
    }

    public int hashCode() {
        return ((this.status == null ? 0 : this.status.hashCode()) * 31) + (this.episodes != null ? this.episodes.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "EpisodesResponse(status=" + this.status + ", episodes=" + this.episodes + ')';
    }

    public EpisodesResponse(@Nullable String status, @Nullable List<EpisodeItem> list) {
        this.status = status;
        this.episodes = list;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final List<EpisodeItem> getEpisodes() {
        return this.episodes;
    }
}
