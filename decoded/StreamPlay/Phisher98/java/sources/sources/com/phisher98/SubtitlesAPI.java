package com.phisher98;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/phisher98/SubtitlesAPI;", "", "subtitles", "", "Lcom/phisher98/Subtitle;", "cacheMaxAge", "", "<init>", "(Ljava/util/List;J)V", "getSubtitles", "()Ljava/util/List;", "getCacheMaxAge", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class SubtitlesAPI {
    private final long cacheMaxAge;

    @NotNull
    private final List<Subtitle> subtitles;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SubtitlesAPI copy$default(SubtitlesAPI subtitlesAPI, List list, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            list = subtitlesAPI.subtitles;
        }
        if ((i & 2) != 0) {
            j = subtitlesAPI.cacheMaxAge;
        }
        return subtitlesAPI.copy(list, j);
    }

    @NotNull
    public final List<Subtitle> component1() {
        return this.subtitles;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getCacheMaxAge() {
        return this.cacheMaxAge;
    }

    @NotNull
    public final SubtitlesAPI copy(@NotNull List<Subtitle> subtitles, long cacheMaxAge) {
        return new SubtitlesAPI(subtitles, cacheMaxAge);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubtitlesAPI)) {
            return false;
        }
        SubtitlesAPI subtitlesAPI = (SubtitlesAPI) other;
        return Intrinsics.areEqual(this.subtitles, subtitlesAPI.subtitles) && this.cacheMaxAge == subtitlesAPI.cacheMaxAge;
    }

    public int hashCode() {
        return (this.subtitles.hashCode() * 31) + SubtitlesAPI$$ExternalSyntheticBackport0.m32m(this.cacheMaxAge);
    }

    @NotNull
    public String toString() {
        return "SubtitlesAPI(subtitles=" + this.subtitles + ", cacheMaxAge=" + this.cacheMaxAge + ')';
    }

    public SubtitlesAPI(@NotNull List<Subtitle> list, long cacheMaxAge) {
        this.subtitles = list;
        this.cacheMaxAge = cacheMaxAge;
    }

    @NotNull
    public final List<Subtitle> getSubtitles() {
        return this.subtitles;
    }

    public final long getCacheMaxAge() {
        return this.cacheMaxAge;
    }
}
