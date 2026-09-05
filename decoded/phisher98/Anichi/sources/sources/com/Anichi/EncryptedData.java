package com.Anichi;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnichiParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Anichi/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bÊ\u0001\u0002\b\u0014¨\u0006\u0013"}, d2 = {"Lcom/Anichi/EncryptedData;", "", "_m", "", "tobeparsed", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "get_m", "()Ljava/lang/String;", "getTobeparsed", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Anichi", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class EncryptedData {

    @Nullable
    private final String _m;

    @Nullable
    private final String tobeparsed;

    /* JADX WARN: Illegal instructions before constructor call */
    public EncryptedData() {
        String str = null;
        this(str, str, 3, str);
    }

    public static /* synthetic */ EncryptedData copy$default(EncryptedData encryptedData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = encryptedData._m;
        }
        if ((i & 2) != 0) {
            str2 = encryptedData.tobeparsed;
        }
        return encryptedData.copy(str, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String get_m() {
        return this._m;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTobeparsed() {
        return this.tobeparsed;
    }

    @NotNull
    public final EncryptedData copy(@Nullable String _m, @Nullable String tobeparsed) {
        return new EncryptedData(_m, tobeparsed);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EncryptedData)) {
            return false;
        }
        EncryptedData encryptedData = (EncryptedData) other;
        return Intrinsics.areEqual(this._m, encryptedData._m) && Intrinsics.areEqual(this.tobeparsed, encryptedData.tobeparsed);
    }

    public int hashCode() {
        return ((this._m == null ? 0 : this._m.hashCode()) * 31) + (this.tobeparsed != null ? this.tobeparsed.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "EncryptedData(_m=" + this._m + ", tobeparsed=" + this.tobeparsed + ')';
    }

    public EncryptedData(@Nullable String _m, @Nullable String tobeparsed) {
        this._m = _m;
        this.tobeparsed = tobeparsed;
    }

    public /* synthetic */ EncryptedData(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    @Nullable
    public final String get_m() {
        return this._m;
    }

    @Nullable
    public final String getTobeparsed() {
        return this.tobeparsed;
    }
}
