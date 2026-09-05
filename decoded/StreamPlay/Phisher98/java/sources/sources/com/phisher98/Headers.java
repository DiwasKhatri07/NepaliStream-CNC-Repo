package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JW\u0010\u0014\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\nHÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/phisher98/Headers;", "", "referer", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "Referer", "origin", "Origin", "userAgent", "user-agent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getReferer", "()Ljava/lang/String;", "getOrigin", "getUserAgent", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Headers {

    @Nullable
    private final String origin;

    @Nullable
    private final String referer;

    @Nullable
    private final String userAgent;

    public Headers() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ Headers copy$default(Headers headers, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = headers.referer;
        }
        if ((i & 2) != 0) {
            str2 = headers.origin;
        }
        if ((i & 4) != 0) {
            str3 = headers.userAgent;
        }
        return headers.copy(str, str2, str3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getReferer() {
        return this.referer;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOrigin() {
        return this.origin;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUserAgent() {
        return this.userAgent;
    }

    @NotNull
    public final Headers copy(@JsonProperty("Referer") @Nullable String referer, @JsonProperty("Origin") @Nullable String origin, @JsonProperty("user-agent") @Nullable String userAgent) {
        return new Headers(referer, origin, userAgent);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Headers)) {
            return false;
        }
        Headers headers = (Headers) other;
        return Intrinsics.areEqual(this.referer, headers.referer) && Intrinsics.areEqual(this.origin, headers.origin) && Intrinsics.areEqual(this.userAgent, headers.userAgent);
    }

    public int hashCode() {
        return ((((this.referer == null ? 0 : this.referer.hashCode()) * 31) + (this.origin == null ? 0 : this.origin.hashCode())) * 31) + (this.userAgent != null ? this.userAgent.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Headers(referer=" + this.referer + ", origin=" + this.origin + ", userAgent=" + this.userAgent + ')';
    }

    public Headers(@JsonProperty("Referer") @Nullable String referer, @JsonProperty("Origin") @Nullable String origin, @JsonProperty("user-agent") @Nullable String userAgent) {
        this.referer = referer;
        this.origin = origin;
        this.userAgent = userAgent;
    }

    public /* synthetic */ Headers(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    @Nullable
    public final String getReferer() {
        return this.referer;
    }

    @Nullable
    public final String getOrigin() {
        return this.origin;
    }

    @Nullable
    public final String getUserAgent() {
        return this.userAgent;
    }
}
