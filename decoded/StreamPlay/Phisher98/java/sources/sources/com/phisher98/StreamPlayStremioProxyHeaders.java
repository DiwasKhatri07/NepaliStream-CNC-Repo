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
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0004HÖ\u0081\u0004R3\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/phisher98/StreamPlayStremioProxyHeaders;", "", "request", "", "", "<init>", "(Ljava/util/Map;)V", "getRequest", "()Ljava/util/Map;", "Lcom/google/gson/annotations/SerializedName;", "value", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class StreamPlayStremioProxyHeaders {

    @SerializedName("request")
    @Nullable
    private final Map<String, String> request;

    /* JADX WARN: Illegal instructions before constructor call */
    public StreamPlayStremioProxyHeaders() {
        Map map = null;
        this(map, 1, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StreamPlayStremioProxyHeaders copy$default(StreamPlayStremioProxyHeaders streamPlayStremioProxyHeaders, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = streamPlayStremioProxyHeaders.request;
        }
        return streamPlayStremioProxyHeaders.copy(map);
    }

    @Nullable
    public final Map<String, String> component1() {
        return this.request;
    }

    @NotNull
    public final StreamPlayStremioProxyHeaders copy(@Nullable Map<String, String> request) {
        return new StreamPlayStremioProxyHeaders(request);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof StreamPlayStremioProxyHeaders) && Intrinsics.areEqual(this.request, ((StreamPlayStremioProxyHeaders) other).request);
    }

    public int hashCode() {
        if (this.request == null) {
            return 0;
        }
        return this.request.hashCode();
    }

    @NotNull
    public String toString() {
        return "StreamPlayStremioProxyHeaders(request=" + this.request + ')';
    }

    public StreamPlayStremioProxyHeaders(@Nullable Map<String, String> map) {
        this.request = map;
    }

    public /* synthetic */ StreamPlayStremioProxyHeaders(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : map);
    }

    @Nullable
    public final Map<String, String> getRequest() {
        return this.request;
    }
}
