package com.Fibwatch;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Fibwatch/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/Fibwatch/EpisodeInfo;", "", "season", "", "episodeStart", "episodeEnd", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getSeason", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEpisodeStart", "getEpisodeEnd", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/Fibwatch/EpisodeInfo;", "equals", "", "other", "hashCode", "toString", "", "Fibwatch"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class EpisodeInfo {

    @Nullable
    private final Integer episodeEnd;

    @Nullable
    private final Integer episodeStart;

    @Nullable
    private final Integer season;

    public static /* synthetic */ EpisodeInfo copy$default(EpisodeInfo episodeInfo, Integer num, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = episodeInfo.season;
        }
        if ((i & 2) != 0) {
            num2 = episodeInfo.episodeStart;
        }
        if ((i & 4) != 0) {
            num3 = episodeInfo.episodeEnd;
        }
        return episodeInfo.copy(num, num2, num3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getSeason() {
        return this.season;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getEpisodeStart() {
        return this.episodeStart;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getEpisodeEnd() {
        return this.episodeEnd;
    }

    @NotNull
    public final EpisodeInfo copy(@Nullable Integer season, @Nullable Integer episodeStart, @Nullable Integer episodeEnd) {
        return new EpisodeInfo(season, episodeStart, episodeEnd);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EpisodeInfo)) {
            return false;
        }
        EpisodeInfo episodeInfo = (EpisodeInfo) other;
        return Intrinsics.areEqual(this.season, episodeInfo.season) && Intrinsics.areEqual(this.episodeStart, episodeInfo.episodeStart) && Intrinsics.areEqual(this.episodeEnd, episodeInfo.episodeEnd);
    }

    public int hashCode() {
        return ((((this.season == null ? 0 : this.season.hashCode()) * 31) + (this.episodeStart == null ? 0 : this.episodeStart.hashCode())) * 31) + (this.episodeEnd != null ? this.episodeEnd.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "EpisodeInfo(season=" + this.season + ", episodeStart=" + this.episodeStart + ", episodeEnd=" + this.episodeEnd + ')';
    }

    public EpisodeInfo(@Nullable Integer season, @Nullable Integer episodeStart, @Nullable Integer episodeEnd) {
        this.season = season;
        this.episodeStart = episodeStart;
        this.episodeEnd = episodeEnd;
    }

    @Nullable
    public final Integer getSeason() {
        return this.season;
    }

    @Nullable
    public final Integer getEpisodeStart() {
        return this.episodeStart;
    }

    @Nullable
    public final Integer getEpisodeEnd() {
        return this.episodeEnd;
    }
}
