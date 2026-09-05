package com.OneTouchTV;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: OneTouchTVParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/OneTouchTV/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/OneTouchTV/TrackItem;", "", "file", "", "name", "isDefault", "", "kind", "format", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getName", "()Z", "getKind", "getFormat", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "OneTouchTV"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class TrackItem {

    @Nullable
    private final String file;

    @Nullable
    private final String format;
    private final boolean isDefault;

    @Nullable
    private final String kind;

    @Nullable
    private final String name;

    public static /* synthetic */ TrackItem copy$default(TrackItem trackItem, String str, String str2, boolean z, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = trackItem.file;
        }
        if ((i & 2) != 0) {
            str2 = trackItem.name;
        }
        if ((i & 4) != 0) {
            z = trackItem.isDefault;
        }
        if ((i & 8) != 0) {
            str3 = trackItem.kind;
        }
        if ((i & 16) != 0) {
            str4 = trackItem.format;
        }
        String str5 = str4;
        boolean z2 = z;
        return trackItem.copy(str, str2, z2, str3, str5);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFile() {
        return this.file;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsDefault() {
        return this.isDefault;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getKind() {
        return this.kind;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getFormat() {
        return this.format;
    }

    @NotNull
    public final TrackItem copy(@Nullable String file, @Nullable String name, boolean isDefault, @Nullable String kind, @Nullable String format) {
        return new TrackItem(file, name, isDefault, kind, format);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackItem)) {
            return false;
        }
        TrackItem trackItem = (TrackItem) other;
        return Intrinsics.areEqual(this.file, trackItem.file) && Intrinsics.areEqual(this.name, trackItem.name) && this.isDefault == trackItem.isDefault && Intrinsics.areEqual(this.kind, trackItem.kind) && Intrinsics.areEqual(this.format, trackItem.format);
    }

    public int hashCode() {
        return ((((((((this.file == null ? 0 : this.file.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + TrackItem$$ExternalSyntheticBackport0.m7m(this.isDefault)) * 31) + (this.kind == null ? 0 : this.kind.hashCode())) * 31) + (this.format != null ? this.format.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "TrackItem(file=" + this.file + ", name=" + this.name + ", isDefault=" + this.isDefault + ", kind=" + this.kind + ", format=" + this.format + ')';
    }

    public TrackItem(@Nullable String file, @Nullable String name, boolean isDefault, @Nullable String kind, @Nullable String format) {
        this.file = file;
        this.name = name;
        this.isDefault = isDefault;
        this.kind = kind;
        this.format = format;
    }

    @Nullable
    public final String getFile() {
        return this.file;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    @Nullable
    public final String getKind() {
        return this.kind;
    }

    @Nullable
    public final String getFormat() {
        return this.format;
    }
}
