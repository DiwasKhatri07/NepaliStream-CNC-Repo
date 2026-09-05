package com.horis.cncverse;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/CNC_Verse_Mobile/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/horis/cncverse/NewTvTokenResponse;", "", "token_hash", "", "<init>", "(Ljava/lang/String;)V", "getToken_hash", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "CNC Verse Mobile_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class NewTvTokenResponse {

    @Nullable
    private final String token_hash;

    /* JADX WARN: Illegal instructions before constructor call */
    public NewTvTokenResponse() {
        String str = null;
        this(str, 1, str);
    }

    public static /* synthetic */ NewTvTokenResponse copy$default(NewTvTokenResponse newTvTokenResponse, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = newTvTokenResponse.token_hash;
        }
        return newTvTokenResponse.copy(str);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getToken_hash() {
        return this.token_hash;
    }

    @NotNull
    public final NewTvTokenResponse copy(@Nullable String token_hash) {
        return new NewTvTokenResponse(token_hash);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof NewTvTokenResponse) && Intrinsics.areEqual(this.token_hash, ((NewTvTokenResponse) other).token_hash);
    }

    public int hashCode() {
        if (this.token_hash == null) {
            return 0;
        }
        return this.token_hash.hashCode();
    }

    @NotNull
    public String toString() {
        return "NewTvTokenResponse(token_hash=" + this.token_hash + ')';
    }

    public NewTvTokenResponse(@Nullable String token_hash) {
        this.token_hash = token_hash;
    }

    public /* synthetic */ NewTvTokenResponse(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    @Nullable
    public final String getToken_hash() {
        return this.token_hash;
    }
}
