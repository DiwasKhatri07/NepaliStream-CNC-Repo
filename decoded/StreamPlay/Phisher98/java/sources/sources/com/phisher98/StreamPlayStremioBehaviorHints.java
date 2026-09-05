package com.phisher98;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayStremioAddon.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0006HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR3\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/phisher98/StreamPlayStremioBehaviorHints;", "", "proxyHeaders", "Lcom/phisher98/StreamPlayStremioProxyHeaders;", "headers", "", "", "<init>", "(Lcom/phisher98/StreamPlayStremioProxyHeaders;Ljava/util/Map;)V", "getProxyHeaders", "()Lcom/phisher98/StreamPlayStremioProxyHeaders;", "Lcom/google/gson/annotations/SerializedName;", "value", "getHeaders", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class StreamPlayStremioBehaviorHints {

    @SerializedName("headers")
    @Nullable
    private final Map<String, String> headers;

    @SerializedName("proxyHeaders")
    @Nullable
    private final StreamPlayStremioProxyHeaders proxyHeaders;

    /* JADX WARN: Multi-variable type inference failed */
    public StreamPlayStremioBehaviorHints() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StreamPlayStremioBehaviorHints copy$default(StreamPlayStremioBehaviorHints streamPlayStremioBehaviorHints, StreamPlayStremioProxyHeaders streamPlayStremioProxyHeaders, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            streamPlayStremioProxyHeaders = streamPlayStremioBehaviorHints.proxyHeaders;
        }
        if ((i & 2) != 0) {
            map = streamPlayStremioBehaviorHints.headers;
        }
        return streamPlayStremioBehaviorHints.copy(streamPlayStremioProxyHeaders, map);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StreamPlayStremioProxyHeaders getProxyHeaders() {
        return this.proxyHeaders;
    }

    @Nullable
    public final Map<String, String> component2() {
        return this.headers;
    }

    @NotNull
    public final StreamPlayStremioBehaviorHints copy(@Nullable StreamPlayStremioProxyHeaders proxyHeaders, @Nullable Map<String, String> headers) {
        return new StreamPlayStremioBehaviorHints(proxyHeaders, headers);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StreamPlayStremioBehaviorHints)) {
            return false;
        }
        StreamPlayStremioBehaviorHints streamPlayStremioBehaviorHints = (StreamPlayStremioBehaviorHints) other;
        return Intrinsics.areEqual(this.proxyHeaders, streamPlayStremioBehaviorHints.proxyHeaders) && Intrinsics.areEqual(this.headers, streamPlayStremioBehaviorHints.headers);
    }

    public int hashCode() {
        return ((this.proxyHeaders == null ? 0 : this.proxyHeaders.hashCode()) * 31) + (this.headers != null ? this.headers.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "StreamPlayStremioBehaviorHints(proxyHeaders=" + this.proxyHeaders + ", headers=" + this.headers + ')';
    }

    public StreamPlayStremioBehaviorHints(@Nullable StreamPlayStremioProxyHeaders proxyHeaders, @Nullable Map<String, String> map) {
        this.proxyHeaders = proxyHeaders;
        this.headers = map;
    }

    public /* synthetic */ StreamPlayStremioBehaviorHints(StreamPlayStremioProxyHeaders streamPlayStremioProxyHeaders, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : streamPlayStremioProxyHeaders, (i & 2) != 0 ? null : map);
    }

    @Nullable
    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    @Nullable
    public final StreamPlayStremioProxyHeaders getProxyHeaders() {
        return this.proxyHeaders;
    }
}
