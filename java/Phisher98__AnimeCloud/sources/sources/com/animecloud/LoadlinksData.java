package com.animecloud;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/AnimeCloud/classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J_\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001J\u0014\u0010&\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010(\u001a\u00020)HÖ\u0081\u0004J\n\u0010*\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"}, d2 = {"Lcom/animecloud/LoadlinksData;", "", "id", "", "episode", "", "animeSeasonId", "hasGerSub", "", "hasEngSub", "hasGerDub", "likeCount", "animeEpisodeLinks", "", "Lcom/animecloud/AnimeEpisodeLink;", "<init>", "(JLjava/lang/String;JZZZJLjava/util/List;)V", "getId", "()J", "getEpisode", "()Ljava/lang/String;", "getAnimeSeasonId", "getHasGerSub", "()Z", "getHasEngSub", "getHasGerDub", "getLikeCount", "getAnimeEpisodeLinks", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "AnimeCloud"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class LoadlinksData {

    @NotNull
    private final List<AnimeEpisodeLink> animeEpisodeLinks;
    private final long animeSeasonId;

    @NotNull
    private final String episode;
    private final boolean hasEngSub;
    private final boolean hasGerDub;
    private final boolean hasGerSub;
    private final long id;
    private final long likeCount;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LoadlinksData copy$default(LoadlinksData loadlinksData, long j, String str, long j2, boolean z, boolean z2, boolean z3, long j3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j = loadlinksData.id;
        }
        long j4 = j;
        if ((i & 2) != 0) {
            str = loadlinksData.episode;
        }
        return loadlinksData.copy(j4, str, (i & 4) != 0 ? loadlinksData.animeSeasonId : j2, (i & 8) != 0 ? loadlinksData.hasGerSub : z, (i & 16) != 0 ? loadlinksData.hasEngSub : z2, (i & 32) != 0 ? loadlinksData.hasGerDub : z3, (i & 64) != 0 ? loadlinksData.likeCount : j3, (i & 128) != 0 ? loadlinksData.animeEpisodeLinks : list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEpisode() {
        return this.episode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getAnimeSeasonId() {
        return this.animeSeasonId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getHasGerSub() {
        return this.hasGerSub;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getHasEngSub() {
        return this.hasEngSub;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getHasGerDub() {
        return this.hasGerDub;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getLikeCount() {
        return this.likeCount;
    }

    @NotNull
    public final List<AnimeEpisodeLink> component8() {
        return this.animeEpisodeLinks;
    }

    @NotNull
    public final LoadlinksData copy(long id, @NotNull String episode, long animeSeasonId, boolean hasGerSub, boolean hasEngSub, boolean hasGerDub, long likeCount, @NotNull List<AnimeEpisodeLink> animeEpisodeLinks) {
        return new LoadlinksData(id, episode, animeSeasonId, hasGerSub, hasEngSub, hasGerDub, likeCount, animeEpisodeLinks);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoadlinksData)) {
            return false;
        }
        LoadlinksData loadlinksData = (LoadlinksData) other;
        return this.id == loadlinksData.id && Intrinsics.areEqual(this.episode, loadlinksData.episode) && this.animeSeasonId == loadlinksData.animeSeasonId && this.hasGerSub == loadlinksData.hasGerSub && this.hasEngSub == loadlinksData.hasEngSub && this.hasGerDub == loadlinksData.hasGerDub && this.likeCount == loadlinksData.likeCount && Intrinsics.areEqual(this.animeEpisodeLinks, loadlinksData.animeEpisodeLinks);
    }

    public int hashCode() {
        return (((((((((((((LoadlinksData$$ExternalSyntheticBackport0.m10m(this.id) * 31) + this.episode.hashCode()) * 31) + LoadlinksData$$ExternalSyntheticBackport0.m10m(this.animeSeasonId)) * 31) + LoadlinksData$$ExternalSyntheticBackport1.m11m(this.hasGerSub)) * 31) + LoadlinksData$$ExternalSyntheticBackport1.m11m(this.hasEngSub)) * 31) + LoadlinksData$$ExternalSyntheticBackport1.m11m(this.hasGerDub)) * 31) + LoadlinksData$$ExternalSyntheticBackport0.m10m(this.likeCount)) * 31) + this.animeEpisodeLinks.hashCode();
    }

    @NotNull
    public String toString() {
        return "LoadlinksData(id=" + this.id + ", episode=" + this.episode + ", animeSeasonId=" + this.animeSeasonId + ", hasGerSub=" + this.hasGerSub + ", hasEngSub=" + this.hasEngSub + ", hasGerDub=" + this.hasGerDub + ", likeCount=" + this.likeCount + ", animeEpisodeLinks=" + this.animeEpisodeLinks + ')';
    }

    public LoadlinksData(long id, @NotNull String episode, long animeSeasonId, boolean hasGerSub, boolean hasEngSub, boolean hasGerDub, long likeCount, @NotNull List<AnimeEpisodeLink> list) {
        this.id = id;
        this.episode = episode;
        this.animeSeasonId = animeSeasonId;
        this.hasGerSub = hasGerSub;
        this.hasEngSub = hasEngSub;
        this.hasGerDub = hasGerDub;
        this.likeCount = likeCount;
        this.animeEpisodeLinks = list;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getEpisode() {
        return this.episode;
    }

    public final long getAnimeSeasonId() {
        return this.animeSeasonId;
    }

    public final boolean getHasGerSub() {
        return this.hasGerSub;
    }

    public final boolean getHasEngSub() {
        return this.hasEngSub;
    }

    public final boolean getHasGerDub() {
        return this.hasGerDub;
    }

    public final long getLikeCount() {
        return this.likeCount;
    }

    @NotNull
    public final List<AnimeEpisodeLink> getAnimeEpisodeLinks() {
        return this.animeEpisodeLinks;
    }
}
