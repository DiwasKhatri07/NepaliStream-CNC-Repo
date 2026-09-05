package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/phisher98/FsonicData;", "", "file", "Lcom/phisher98/FsonicFile;", "<init>", "(Lcom/phisher98/FsonicFile;)V", "getFile", "()Lcom/phisher98/FsonicFile;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class FsonicData {

    @Nullable
    private final FsonicFile file;

    /* JADX WARN: Illegal instructions before constructor call */
    public FsonicData() {
        FsonicFile fsonicFile = null;
        this(fsonicFile, 1, fsonicFile);
    }

    public static /* synthetic */ FsonicData copy$default(FsonicData fsonicData, FsonicFile fsonicFile, int i, Object obj) {
        if ((i & 1) != 0) {
            fsonicFile = fsonicData.file;
        }
        return fsonicData.copy(fsonicFile);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final FsonicFile getFile() {
        return this.file;
    }

    @NotNull
    public final FsonicData copy(@Nullable FsonicFile file) {
        return new FsonicData(file);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FsonicData) && Intrinsics.areEqual(this.file, ((FsonicData) other).file);
    }

    public int hashCode() {
        if (this.file == null) {
            return 0;
        }
        return this.file.hashCode();
    }

    @NotNull
    public String toString() {
        return "FsonicData(file=" + this.file + ')';
    }

    public FsonicData(@Nullable FsonicFile file) {
        this.file = file;
    }

    public /* synthetic */ FsonicData(FsonicFile fsonicFile, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : fsonicFile);
    }

    @Nullable
    public final FsonicFile getFile() {
        return this.file;
    }
}
