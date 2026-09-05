package com.phisher98;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003JE\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\bHÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/phisher98/VideasyResult;", "", "sources", "", "Lcom/phisher98/VideasySource;", "subtitles", "Lcom/phisher98/VideasySubtitle;", "playlist", "", "thumbnail", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getSources", "()Ljava/util/List;", "getSubtitles", "getPlaylist", "()Ljava/lang/String;", "getThumbnail", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class VideasyResult {

    @Nullable
    private final String playlist;

    @Nullable
    private final List<VideasySource> sources;

    @Nullable
    private final List<VideasySubtitle> subtitles;

    @Nullable
    private final String thumbnail;

    public VideasyResult() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VideasyResult copy$default(VideasyResult videasyResult, List list, List list2, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = videasyResult.sources;
        }
        if ((i & 2) != 0) {
            list2 = videasyResult.subtitles;
        }
        if ((i & 4) != 0) {
            str = videasyResult.playlist;
        }
        if ((i & 8) != 0) {
            str2 = videasyResult.thumbnail;
        }
        return videasyResult.copy(list, list2, str, str2);
    }

    @Nullable
    public final List<VideasySource> component1() {
        return this.sources;
    }

    @Nullable
    public final List<VideasySubtitle> component2() {
        return this.subtitles;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPlaylist() {
        return this.playlist;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getThumbnail() {
        return this.thumbnail;
    }

    @NotNull
    public final VideasyResult copy(@Nullable List<VideasySource> sources, @Nullable List<VideasySubtitle> subtitles, @Nullable String playlist, @Nullable String thumbnail) {
        return new VideasyResult(sources, subtitles, playlist, thumbnail);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideasyResult)) {
            return false;
        }
        VideasyResult videasyResult = (VideasyResult) other;
        return Intrinsics.areEqual(this.sources, videasyResult.sources) && Intrinsics.areEqual(this.subtitles, videasyResult.subtitles) && Intrinsics.areEqual(this.playlist, videasyResult.playlist) && Intrinsics.areEqual(this.thumbnail, videasyResult.thumbnail);
    }

    public int hashCode() {
        return ((((((this.sources == null ? 0 : this.sources.hashCode()) * 31) + (this.subtitles == null ? 0 : this.subtitles.hashCode())) * 31) + (this.playlist == null ? 0 : this.playlist.hashCode())) * 31) + (this.thumbnail != null ? this.thumbnail.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "VideasyResult(sources=" + this.sources + ", subtitles=" + this.subtitles + ", playlist=" + this.playlist + ", thumbnail=" + this.thumbnail + ')';
    }

    public VideasyResult(@Nullable List<VideasySource> list, @Nullable List<VideasySubtitle> list2, @Nullable String playlist, @Nullable String thumbnail) {
        this.sources = list;
        this.subtitles = list2;
        this.playlist = playlist;
        this.thumbnail = thumbnail;
    }

    public /* synthetic */ VideasyResult(List list, List list2, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2);
    }

    @Nullable
    public final List<VideasySource> getSources() {
        return this.sources;
    }

    @Nullable
    public final List<VideasySubtitle> getSubtitles() {
        return this.subtitles;
    }

    @Nullable
    public final String getPlaylist() {
        return this.playlist;
    }

    @Nullable
    public final String getThumbnail() {
        return this.thumbnail;
    }
}
