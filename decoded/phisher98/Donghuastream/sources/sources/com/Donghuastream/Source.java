package com.Donghuastream;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Donghuastreamparser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Donghuastream/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/Donghuastream/Source;", "", "file", "", "type", "label", "default", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getFile", "()Ljava/lang/String;", "getType", "getLabel", "getDefault", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "Donghuastream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Source {
    private final boolean default;

    @NotNull
    private final String file;

    @NotNull
    private final String label;

    @NotNull
    private final String type;

    public static /* synthetic */ Source copy$default(Source source, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = source.file;
        }
        if ((i & 2) != 0) {
            str2 = source.type;
        }
        if ((i & 4) != 0) {
            str3 = source.label;
        }
        if ((i & 8) != 0) {
            z = source.default;
        }
        return source.copy(str, str2, str3, z);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFile() {
        return this.file;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getDefault() {
        return this.default;
    }

    @NotNull
    public final Source copy(@NotNull String file, @NotNull String type, @NotNull String label, boolean z) {
        return new Source(file, type, label, z);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Source)) {
            return false;
        }
        Source source = (Source) other;
        return Intrinsics.areEqual(this.file, source.file) && Intrinsics.areEqual(this.type, source.type) && Intrinsics.areEqual(this.label, source.label) && this.default == source.default;
    }

    public int hashCode() {
        return (((((this.file.hashCode() * 31) + this.type.hashCode()) * 31) + this.label.hashCode()) * 31) + Source$$ExternalSyntheticBackport0.m1m(this.default);
    }

    @NotNull
    public String toString() {
        return "Source(file=" + this.file + ", type=" + this.type + ", label=" + this.label + ", default=" + this.default + ')';
    }

    public Source(@NotNull String file, @NotNull String type, @NotNull String label, boolean z) {
        this.file = file;
        this.type = type;
        this.label = label;
        this.default = z;
    }

    @NotNull
    public final String getFile() {
        return this.file;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }

    public final boolean getDefault() {
        return this.default;
    }
}
