package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/phisher98/HiAnimeTrack;", "", "file", "", "label", "kind", "default", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getFile", "()Ljava/lang/String;", "getLabel", "getKind", "getDefault", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/phisher98/HiAnimeTrack;", "equals", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class HiAnimeTrack {

    @Nullable
    private final Boolean default;

    @Nullable
    private final String file;

    @Nullable
    private final String kind;

    @Nullable
    private final String label;

    public static /* synthetic */ HiAnimeTrack copy$default(HiAnimeTrack hiAnimeTrack, String str, String str2, String str3, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hiAnimeTrack.file;
        }
        if ((i & 2) != 0) {
            str2 = hiAnimeTrack.label;
        }
        if ((i & 4) != 0) {
            str3 = hiAnimeTrack.kind;
        }
        if ((i & 8) != 0) {
            bool = hiAnimeTrack.default;
        }
        return hiAnimeTrack.copy(str, str2, str3, bool);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFile() {
        return this.file;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getKind() {
        return this.kind;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getDefault() {
        return this.default;
    }

    @NotNull
    public final HiAnimeTrack copy(@Nullable String file, @Nullable String label, @Nullable String kind, @Nullable Boolean bool) {
        return new HiAnimeTrack(file, label, kind, bool);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HiAnimeTrack)) {
            return false;
        }
        HiAnimeTrack hiAnimeTrack = (HiAnimeTrack) other;
        return Intrinsics.areEqual(this.file, hiAnimeTrack.file) && Intrinsics.areEqual(this.label, hiAnimeTrack.label) && Intrinsics.areEqual(this.kind, hiAnimeTrack.kind) && Intrinsics.areEqual(this.default, hiAnimeTrack.default);
    }

    public int hashCode() {
        return ((((((this.file == null ? 0 : this.file.hashCode()) * 31) + (this.label == null ? 0 : this.label.hashCode())) * 31) + (this.kind == null ? 0 : this.kind.hashCode())) * 31) + (this.default != null ? this.default.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "HiAnimeTrack(file=" + this.file + ", label=" + this.label + ", kind=" + this.kind + ", default=" + this.default + ')';
    }

    public HiAnimeTrack(@Nullable String file, @Nullable String label, @Nullable String kind, @Nullable Boolean bool) {
        this.file = file;
        this.label = label;
        this.kind = kind;
        this.default = bool;
    }

    @Nullable
    public final String getFile() {
        return this.file;
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    public final String getKind() {
        return this.kind;
    }

    @Nullable
    public final Boolean getDefault() {
        return this.default;
    }
}
