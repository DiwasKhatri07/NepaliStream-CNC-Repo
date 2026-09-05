package com.Donghuastream;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Donghuastreamparser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Donghuastream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ.\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/Donghuastream/Track;", "", "file", "", "label", "default", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getFile", "()Ljava/lang/String;", "getLabel", "getDefault", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/Donghuastream/Track;", "equals", "other", "hashCode", "", "toString", "Donghuastream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Track {

    @Nullable
    private final Boolean default;

    @NotNull
    private final String file;

    @NotNull
    private final String label;

    public static /* synthetic */ Track copy$default(Track track, String str, String str2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = track.file;
        }
        if ((i & 2) != 0) {
            str2 = track.label;
        }
        if ((i & 4) != 0) {
            bool = track.default;
        }
        return track.copy(str, str2, bool);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFile() {
        return this.file;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getDefault() {
        return this.default;
    }

    @NotNull
    public final Track copy(@NotNull String file, @NotNull String label, @Nullable Boolean bool) {
        return new Track(file, label, bool);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Track)) {
            return false;
        }
        Track track = (Track) other;
        return Intrinsics.areEqual(this.file, track.file) && Intrinsics.areEqual(this.label, track.label) && Intrinsics.areEqual(this.default, track.default);
    }

    public int hashCode() {
        return (((this.file.hashCode() * 31) + this.label.hashCode()) * 31) + (this.default == null ? 0 : this.default.hashCode());
    }

    @NotNull
    public String toString() {
        return "Track(file=" + this.file + ", label=" + this.label + ", default=" + this.default + ')';
    }

    public Track(@NotNull String file, @NotNull String label, @Nullable Boolean bool) {
        this.file = file;
        this.label = label;
        this.default = bool;
    }

    @NotNull
    public final String getFile() {
        return this.file;
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    public final Boolean getDefault() {
        return this.default;
    }
}
