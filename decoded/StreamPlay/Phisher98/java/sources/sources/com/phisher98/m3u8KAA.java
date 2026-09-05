package com.phisher98;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/phisher98/m3u8KAA;", "", "hls", "", "subtitles", "", "Lcom/phisher98/SubtitleKAA;", "key", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getHls", "()Ljava/lang/String;", "getSubtitles", "()Ljava/util/List;", "getKey", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class m3u8KAA {

    @NotNull
    private final String hls;

    @NotNull
    private final String key;

    @NotNull
    private final List<SubtitleKAA> subtitles;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ m3u8KAA copy$default(m3u8KAA m3u8kaa, String str, List list, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = m3u8kaa.hls;
        }
        if ((i & 2) != 0) {
            list = m3u8kaa.subtitles;
        }
        if ((i & 4) != 0) {
            str2 = m3u8kaa.key;
        }
        return m3u8kaa.copy(str, list, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getHls() {
        return this.hls;
    }

    @NotNull
    public final List<SubtitleKAA> component2() {
        return this.subtitles;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    @NotNull
    public final m3u8KAA copy(@NotNull String hls, @NotNull List<SubtitleKAA> subtitles, @NotNull String key) {
        return new m3u8KAA(hls, subtitles, key);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof m3u8KAA)) {
            return false;
        }
        m3u8KAA m3u8kaa = (m3u8KAA) other;
        return Intrinsics.areEqual(this.hls, m3u8kaa.hls) && Intrinsics.areEqual(this.subtitles, m3u8kaa.subtitles) && Intrinsics.areEqual(this.key, m3u8kaa.key);
    }

    public int hashCode() {
        return (((this.hls.hashCode() * 31) + this.subtitles.hashCode()) * 31) + this.key.hashCode();
    }

    @NotNull
    public String toString() {
        return "m3u8KAA(hls=" + this.hls + ", subtitles=" + this.subtitles + ", key=" + this.key + ')';
    }

    public m3u8KAA(@NotNull String hls, @NotNull List<SubtitleKAA> list, @NotNull String key) {
        this.hls = hls;
        this.subtitles = list;
        this.key = key;
    }

    @NotNull
    public final String getHls() {
        return this.hls;
    }

    @NotNull
    public final List<SubtitleKAA> getSubtitles() {
        return this.subtitles;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }
}
