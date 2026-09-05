package com.Anichi;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnichiExtractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Anichi/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/Anichi/PlaybackRoot;", "", "playback", "Lcom/Anichi/Playback;", "sources", "", "Lcom/Anichi/PlaybackDecryptSource;", "<init>", "(Lcom/Anichi/Playback;Ljava/util/List;)V", "getPlayback", "()Lcom/Anichi/Playback;", "getSources", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Anichi"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class PlaybackRoot {

    @Nullable
    private final Playback playback;

    @Nullable
    private final List<PlaybackDecryptSource> sources;

    /* JADX WARN: Multi-variable type inference failed */
    public PlaybackRoot() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlaybackRoot copy$default(PlaybackRoot playbackRoot, Playback playback, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            playback = playbackRoot.playback;
        }
        if ((i & 2) != 0) {
            list = playbackRoot.sources;
        }
        return playbackRoot.copy(playback, list);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Playback getPlayback() {
        return this.playback;
    }

    @Nullable
    public final List<PlaybackDecryptSource> component2() {
        return this.sources;
    }

    @NotNull
    public final PlaybackRoot copy(@Nullable Playback playback, @Nullable List<PlaybackDecryptSource> sources) {
        return new PlaybackRoot(playback, sources);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlaybackRoot)) {
            return false;
        }
        PlaybackRoot playbackRoot = (PlaybackRoot) other;
        return Intrinsics.areEqual(this.playback, playbackRoot.playback) && Intrinsics.areEqual(this.sources, playbackRoot.sources);
    }

    public int hashCode() {
        return ((this.playback == null ? 0 : this.playback.hashCode()) * 31) + (this.sources != null ? this.sources.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "PlaybackRoot(playback=" + this.playback + ", sources=" + this.sources + ')';
    }

    public PlaybackRoot(@Nullable Playback playback, @Nullable List<PlaybackDecryptSource> list) {
        this.playback = playback;
        this.sources = list;
    }

    public /* synthetic */ PlaybackRoot(Playback playback, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : playback, (i & 2) != 0 ? null : list);
    }

    @Nullable
    public final Playback getPlayback() {
        return this.playback;
    }

    @Nullable
    public final List<PlaybackDecryptSource> getSources() {
        return this.sources;
    }
}
