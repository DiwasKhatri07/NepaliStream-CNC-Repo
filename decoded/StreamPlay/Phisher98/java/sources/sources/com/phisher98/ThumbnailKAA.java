package com.phisher98;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0004HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0004HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/phisher98/ThumbnailKAA;", "", "formats", "", "", "sm", "aspectRatio", "", "hq", "<init>", "(Ljava/util/List;Ljava/lang/String;DLjava/lang/String;)V", "getFormats", "()Ljava/util/List;", "getSm", "()Ljava/lang/String;", "getAspectRatio", "()D", "getHq", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ThumbnailKAA {
    private final double aspectRatio;

    @NotNull
    private final List<String> formats;

    @NotNull
    private final String hq;

    @NotNull
    private final String sm;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ThumbnailKAA copy$default(ThumbnailKAA thumbnailKAA, List list, String str, double d, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = thumbnailKAA.formats;
        }
        if ((i & 2) != 0) {
            str = thumbnailKAA.sm;
        }
        if ((i & 4) != 0) {
            d = thumbnailKAA.aspectRatio;
        }
        if ((i & 8) != 0) {
            str2 = thumbnailKAA.hq;
        }
        String str3 = str2;
        return thumbnailKAA.copy(list, str, d, str3);
    }

    @NotNull
    public final List<String> component1() {
        return this.formats;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSm() {
        return this.sm;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final double getAspectRatio() {
        return this.aspectRatio;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getHq() {
        return this.hq;
    }

    @NotNull
    public final ThumbnailKAA copy(@NotNull List<String> formats, @NotNull String sm, double aspectRatio, @NotNull String hq) {
        return new ThumbnailKAA(formats, sm, aspectRatio, hq);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThumbnailKAA)) {
            return false;
        }
        ThumbnailKAA thumbnailKAA = (ThumbnailKAA) other;
        return Intrinsics.areEqual(this.formats, thumbnailKAA.formats) && Intrinsics.areEqual(this.sm, thumbnailKAA.sm) && Double.compare(this.aspectRatio, thumbnailKAA.aspectRatio) == 0 && Intrinsics.areEqual(this.hq, thumbnailKAA.hq);
    }

    public int hashCode() {
        return (((((this.formats.hashCode() * 31) + this.sm.hashCode()) * 31) + ThumbnailKAA$$ExternalSyntheticBackport0.m33m(this.aspectRatio)) * 31) + this.hq.hashCode();
    }

    @NotNull
    public String toString() {
        return "ThumbnailKAA(formats=" + this.formats + ", sm=" + this.sm + ", aspectRatio=" + this.aspectRatio + ", hq=" + this.hq + ')';
    }

    public ThumbnailKAA(@NotNull List<String> list, @NotNull String sm, double aspectRatio, @NotNull String hq) {
        this.formats = list;
        this.sm = sm;
        this.aspectRatio = aspectRatio;
        this.hq = hq;
    }

    @NotNull
    public final List<String> getFormats() {
        return this.formats;
    }

    @NotNull
    public final String getSm() {
        return this.sm;
    }

    public final double getAspectRatio() {
        return this.aspectRatio;
    }

    @NotNull
    public final String getHq() {
        return this.hq;
    }
}
