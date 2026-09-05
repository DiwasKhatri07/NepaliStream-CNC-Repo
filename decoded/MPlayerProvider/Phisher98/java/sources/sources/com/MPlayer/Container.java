package com.MPlayer;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MPlayerProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\rHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003Jm\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0014\u0010*\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010,\u001a\u00020-HÖ\u0081\u0004J\n\u0010.\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013¨\u0006/"}, d2 = {"Lcom/MPlayer/Container;", "", "title", "", "type", "sequence", "", "imageInfo", "", "Lcom/MPlayer/ImageInfo2;", "aroundApi", "episodesCount", "lastWatched", "", "lastWatchedEpisodeId", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/util/List;Ljava/lang/Object;JZLjava/lang/Object;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getType", "getSequence", "()J", "getImageInfo", "()Ljava/util/List;", "getAroundApi", "()Ljava/lang/Object;", "getEpisodesCount", "getLastWatched", "()Z", "getLastWatchedEpisodeId", "getId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "MPlayerProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Container {

    @Nullable
    private final Object aroundApi;
    private final long episodesCount;

    @NotNull
    private final String id;

    @NotNull
    private final List<ImageInfo2> imageInfo;
    private final boolean lastWatched;

    @Nullable
    private final Object lastWatchedEpisodeId;
    private final long sequence;

    @NotNull
    private final String title;

    @NotNull
    private final String type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Container copy$default(Container container, String str, String str2, long j, List list, Object obj, long j2, boolean z, Object obj2, String str3, int i, Object obj3) {
        if ((i & 1) != 0) {
            str = container.title;
        }
        if ((i & 2) != 0) {
            str2 = container.type;
        }
        if ((i & 4) != 0) {
            j = container.sequence;
        }
        if ((i & 8) != 0) {
            list = container.imageInfo;
        }
        if ((i & 16) != 0) {
            obj = container.aroundApi;
        }
        if ((i & 32) != 0) {
            j2 = container.episodesCount;
        }
        if ((i & 64) != 0) {
            z = container.lastWatched;
        }
        if ((i & 128) != 0) {
            obj2 = container.lastWatchedEpisodeId;
        }
        if ((i & 256) != 0) {
            str3 = container.id;
        }
        String str4 = str3;
        boolean z2 = z;
        long j3 = j2;
        List list2 = list;
        long j4 = j;
        return container.copy(str, str2, j4, list2, obj, j3, z2, obj2, str4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getSequence() {
        return this.sequence;
    }

    @NotNull
    public final List<ImageInfo2> component4() {
        return this.imageInfo;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Object getAroundApi() {
        return this.aroundApi;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getEpisodesCount() {
        return this.episodesCount;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getLastWatched() {
        return this.lastWatched;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Object getLastWatchedEpisodeId() {
        return this.lastWatchedEpisodeId;
    }

    @NotNull
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final Container copy(@NotNull String title, @NotNull String type, long sequence, @NotNull List<ImageInfo2> imageInfo, @Nullable Object aroundApi, long episodesCount, boolean lastWatched, @Nullable Object lastWatchedEpisodeId, @NotNull String id) {
        return new Container(title, type, sequence, imageInfo, aroundApi, episodesCount, lastWatched, lastWatchedEpisodeId, id);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Container)) {
            return false;
        }
        Container container = (Container) other;
        return Intrinsics.areEqual(this.title, container.title) && Intrinsics.areEqual(this.type, container.type) && this.sequence == container.sequence && Intrinsics.areEqual(this.imageInfo, container.imageInfo) && Intrinsics.areEqual(this.aroundApi, container.aroundApi) && this.episodesCount == container.episodesCount && this.lastWatched == container.lastWatched && Intrinsics.areEqual(this.lastWatchedEpisodeId, container.lastWatchedEpisodeId) && Intrinsics.areEqual(this.id, container.id);
    }

    public int hashCode() {
        return (((((((((((((((this.title.hashCode() * 31) + this.type.hashCode()) * 31) + Container$$ExternalSyntheticBackport0.m0m(this.sequence)) * 31) + this.imageInfo.hashCode()) * 31) + (this.aroundApi == null ? 0 : this.aroundApi.hashCode())) * 31) + Container$$ExternalSyntheticBackport0.m0m(this.episodesCount)) * 31) + Container$$ExternalSyntheticBackport1.m1m(this.lastWatched)) * 31) + (this.lastWatchedEpisodeId != null ? this.lastWatchedEpisodeId.hashCode() : 0)) * 31) + this.id.hashCode();
    }

    @NotNull
    public String toString() {
        return "Container(title=" + this.title + ", type=" + this.type + ", sequence=" + this.sequence + ", imageInfo=" + this.imageInfo + ", aroundApi=" + this.aroundApi + ", episodesCount=" + this.episodesCount + ", lastWatched=" + this.lastWatched + ", lastWatchedEpisodeId=" + this.lastWatchedEpisodeId + ", id=" + this.id + ')';
    }

    public Container(@NotNull String title, @NotNull String type, long sequence, @NotNull List<ImageInfo2> list, @Nullable Object aroundApi, long episodesCount, boolean lastWatched, @Nullable Object lastWatchedEpisodeId, @NotNull String id) {
        this.title = title;
        this.type = type;
        this.sequence = sequence;
        this.imageInfo = list;
        this.aroundApi = aroundApi;
        this.episodesCount = episodesCount;
        this.lastWatched = lastWatched;
        this.lastWatchedEpisodeId = lastWatchedEpisodeId;
        this.id = id;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public final long getSequence() {
        return this.sequence;
    }

    @NotNull
    public final List<ImageInfo2> getImageInfo() {
        return this.imageInfo;
    }

    @Nullable
    public final Object getAroundApi() {
        return this.aroundApi;
    }

    public final long getEpisodesCount() {
        return this.episodesCount;
    }

    public final boolean getLastWatched() {
        return this.lastWatched;
    }

    @Nullable
    public final Object getLastWatchedEpisodeId() {
        return this.lastWatchedEpisodeId;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }
}
