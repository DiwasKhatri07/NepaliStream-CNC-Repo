package com.DoraBash;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DoraBashParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/DoraBash/classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/DoraBash/EpJson;", "", "success", "", "data", "Lcom/DoraBash/Data;", "<init>", "(ZLcom/DoraBash/Data;)V", "getSuccess", "()Z", "getData", "()Lcom/DoraBash/Data;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "DoraBash"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class EpJson {

    @NotNull
    private final Data data;
    private final boolean success;

    public static /* synthetic */ EpJson copy$default(EpJson epJson, boolean z, Data data, int i, Object obj) {
        if ((i & 1) != 0) {
            z = epJson.success;
        }
        if ((i & 2) != 0) {
            data = epJson.data;
        }
        return epJson.copy(z, data);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Data getData() {
        return this.data;
    }

    @NotNull
    public final EpJson copy(boolean success, @NotNull Data data) {
        return new EpJson(success, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EpJson)) {
            return false;
        }
        EpJson epJson = (EpJson) other;
        return this.success == epJson.success && Intrinsics.areEqual(this.data, epJson.data);
    }

    public int hashCode() {
        return (EpJson$$ExternalSyntheticBackport0.m12m(this.success) * 31) + this.data.hashCode();
    }

    @NotNull
    public String toString() {
        return "EpJson(success=" + this.success + ", data=" + this.data + ')';
    }

    public EpJson(boolean success, @NotNull Data data) {
        this.success = success;
        this.data = data;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    @NotNull
    public final Data getData() {
        return this.data;
    }
}
