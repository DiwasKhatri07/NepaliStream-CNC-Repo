package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SuperStreamParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/SuperStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/phisher98/FebboxFile;", "", "thumb_small", "", "thumb", "thumb_big", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getThumb_small", "()Ljava/lang/String;", "getThumb", "getThumb_big", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class FebboxFile {

    @Nullable
    private final String thumb;

    @Nullable
    private final String thumb_big;

    @Nullable
    private final String thumb_small;

    public static /* synthetic */ FebboxFile copy$default(FebboxFile febboxFile, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = febboxFile.thumb_small;
        }
        if ((i & 2) != 0) {
            str2 = febboxFile.thumb;
        }
        if ((i & 4) != 0) {
            str3 = febboxFile.thumb_big;
        }
        return febboxFile.copy(str, str2, str3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getThumb_small() {
        return this.thumb_small;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getThumb() {
        return this.thumb;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getThumb_big() {
        return this.thumb_big;
    }

    @NotNull
    public final FebboxFile copy(@Nullable String thumb_small, @Nullable String thumb, @Nullable String thumb_big) {
        return new FebboxFile(thumb_small, thumb, thumb_big);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FebboxFile)) {
            return false;
        }
        FebboxFile febboxFile = (FebboxFile) other;
        return Intrinsics.areEqual(this.thumb_small, febboxFile.thumb_small) && Intrinsics.areEqual(this.thumb, febboxFile.thumb) && Intrinsics.areEqual(this.thumb_big, febboxFile.thumb_big);
    }

    public int hashCode() {
        return ((((this.thumb_small == null ? 0 : this.thumb_small.hashCode()) * 31) + (this.thumb == null ? 0 : this.thumb.hashCode())) * 31) + (this.thumb_big != null ? this.thumb_big.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "FebboxFile(thumb_small=" + this.thumb_small + ", thumb=" + this.thumb + ", thumb_big=" + this.thumb_big + ')';
    }

    public FebboxFile(@Nullable String thumb_small, @Nullable String thumb, @Nullable String thumb_big) {
        this.thumb_small = thumb_small;
        this.thumb = thumb;
        this.thumb_big = thumb_big;
    }

    @Nullable
    public final String getThumb_small() {
        return this.thumb_small;
    }

    @Nullable
    public final String getThumb() {
        return this.thumb;
    }

    @Nullable
    public final String getThumb_big() {
        return this.thumb_big;
    }
}
