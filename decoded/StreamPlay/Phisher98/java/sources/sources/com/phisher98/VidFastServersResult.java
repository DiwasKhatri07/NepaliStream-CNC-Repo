package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/phisher98/VidFastServersResult;", "", "name", "", "data", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getData", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class VidFastServersResult {

    @NotNull
    private final String data;

    @NotNull
    private final String name;

    public static /* synthetic */ VidFastServersResult copy$default(VidFastServersResult vidFastServersResult, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vidFastServersResult.name;
        }
        if ((i & 2) != 0) {
            str2 = vidFastServersResult.data;
        }
        return vidFastServersResult.copy(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getData() {
        return this.data;
    }

    @NotNull
    public final VidFastServersResult copy(@NotNull String name, @NotNull String data) {
        return new VidFastServersResult(name, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VidFastServersResult)) {
            return false;
        }
        VidFastServersResult vidFastServersResult = (VidFastServersResult) other;
        return Intrinsics.areEqual(this.name, vidFastServersResult.name) && Intrinsics.areEqual(this.data, vidFastServersResult.data);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.data.hashCode();
    }

    @NotNull
    public String toString() {
        return "VidFastServersResult(name=" + this.name + ", data=" + this.data + ')';
    }

    public VidFastServersResult(@NotNull String name, @NotNull String data) {
        this.name = name;
        this.data = data;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getData() {
        return this.data;
    }
}
