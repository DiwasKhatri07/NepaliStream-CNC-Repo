package com.cncverse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamFlixWebSocketExtractor.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/StreamFlixProvider/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0004\u000e\u000f\u0010\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/cncverse/StreamFlixWebSocketExtractor;", "", "<init>", "()V", "client", "Lokhttp3/OkHttpClient;", "getEpisodesFromWebSocket", "", "", "Lcom/cncverse/StreamFlixWebSocketExtractor$EpisodeData;", "movieKey", "", "totalSeasons", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "WebSocketRequest", "WebSocketData", "WebSocketBody", "EpisodeData", "StreamFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StreamFlixWebSocketExtractor {

    @NotNull
    private final OkHttpClient client = new OkHttpClient();

    /* JADX INFO: renamed from: com.cncverse.StreamFlixWebSocketExtractor$getEpisodesFromWebSocket$1 */
    /* JADX INFO: compiled from: StreamFlixWebSocketExtractor.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.StreamFlixWebSocketExtractor", f = "StreamFlixWebSocketExtractor.kt", i = {0, 0}, l = {46}, m = "getEpisodesFromWebSocket", n = {"movieKey", "totalSeasons"}, nl = {238}, s = {"L$0", "I$0"}, v = 2)
    static final class C00101 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00101(Continuation<? super C00101> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamFlixWebSocketExtractor.this.getEpisodesFromWebSocket(null, 0, (Continuation) this);
        }
    }

    /* JADX INFO: compiled from: StreamFlixWebSocketExtractor.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/cncverse/StreamFlixWebSocketExtractor$WebSocketRequest;", "", "t", "", "d", "Lcom/cncverse/StreamFlixWebSocketExtractor$WebSocketData;", "<init>", "(Ljava/lang/String;Lcom/cncverse/StreamFlixWebSocketExtractor$WebSocketData;)V", "getT", "()Ljava/lang/String;", "getD", "()Lcom/cncverse/StreamFlixWebSocketExtractor$WebSocketData;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class WebSocketRequest {

        @JsonProperty("d")
        @NotNull
        private final WebSocketData d;

        @JsonProperty("t")
        @NotNull
        private final String t;

        public static /* synthetic */ WebSocketRequest copy$default(WebSocketRequest webSocketRequest, String str, WebSocketData webSocketData, int i, Object obj) {
            if ((i & 1) != 0) {
                str = webSocketRequest.t;
            }
            if ((i & 2) != 0) {
                webSocketData = webSocketRequest.d;
            }
            return webSocketRequest.copy(str, webSocketData);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getT() {
            return this.t;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final WebSocketData getD() {
            return this.d;
        }

        @NotNull
        public final WebSocketRequest copy(@JsonProperty("t") @NotNull String t, @JsonProperty("d") @NotNull WebSocketData d) {
            return new WebSocketRequest(t, d);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WebSocketRequest)) {
                return false;
            }
            WebSocketRequest webSocketRequest = (WebSocketRequest) other;
            return Intrinsics.areEqual(this.t, webSocketRequest.t) && Intrinsics.areEqual(this.d, webSocketRequest.d);
        }

        public int hashCode() {
            return (this.t.hashCode() * 31) + this.d.hashCode();
        }

        @NotNull
        public String toString() {
            return "WebSocketRequest(t=" + this.t + ", d=" + this.d + ')';
        }

        public WebSocketRequest(@JsonProperty("t") @NotNull String t, @JsonProperty("d") @NotNull WebSocketData d) {
            this.t = t;
            this.d = d;
        }

        @NotNull
        public final String getT() {
            return this.t;
        }

        @NotNull
        public final WebSocketData getD() {
            return this.d;
        }
    }

    /* JADX INFO: compiled from: StreamFlixWebSocketExtractor.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/cncverse/StreamFlixWebSocketExtractor$WebSocketData;", "", "a", "", "r", "", "b", "Lcom/cncverse/StreamFlixWebSocketExtractor$WebSocketBody;", "<init>", "(Ljava/lang/String;ILcom/cncverse/StreamFlixWebSocketExtractor$WebSocketBody;)V", "getA", "()Ljava/lang/String;", "getR", "()I", "getB", "()Lcom/cncverse/StreamFlixWebSocketExtractor$WebSocketBody;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "StreamFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class WebSocketData {

        @JsonProperty("a")
        @NotNull
        private final String a;

        @JsonProperty("b")
        @NotNull
        private final WebSocketBody b;

        @JsonProperty("r")
        private final int r;

        public static /* synthetic */ WebSocketData copy$default(WebSocketData webSocketData, String str, int i, WebSocketBody webSocketBody, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = webSocketData.a;
            }
            if ((i2 & 2) != 0) {
                i = webSocketData.r;
            }
            if ((i2 & 4) != 0) {
                webSocketBody = webSocketData.b;
            }
            return webSocketData.copy(str, i, webSocketBody);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getA() {
            return this.a;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getR() {
            return this.r;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final WebSocketBody getB() {
            return this.b;
        }

        @NotNull
        public final WebSocketData copy(@JsonProperty("a") @NotNull String a, @JsonProperty("r") int r, @JsonProperty("b") @NotNull WebSocketBody b) {
            return new WebSocketData(a, r, b);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WebSocketData)) {
                return false;
            }
            WebSocketData webSocketData = (WebSocketData) other;
            return Intrinsics.areEqual(this.a, webSocketData.a) && this.r == webSocketData.r && Intrinsics.areEqual(this.b, webSocketData.b);
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.r) * 31) + this.b.hashCode();
        }

        @NotNull
        public String toString() {
            return "WebSocketData(a=" + this.a + ", r=" + this.r + ", b=" + this.b + ')';
        }

        public WebSocketData(@JsonProperty("a") @NotNull String a, @JsonProperty("r") int r, @JsonProperty("b") @NotNull WebSocketBody b) {
            this.a = a;
            this.r = r;
            this.b = b;
        }

        @NotNull
        public final String getA() {
            return this.a;
        }

        public final int getR() {
            return this.r;
        }

        @NotNull
        public final WebSocketBody getB() {
            return this.b;
        }
    }

    /* JADX INFO: compiled from: StreamFlixWebSocketExtractor.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/cncverse/StreamFlixWebSocketExtractor$WebSocketBody;", "", "p", "", "h", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getP", "()Ljava/lang/String;", "getH", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class WebSocketBody {

        @JsonProperty("h")
        @NotNull
        private final String h;

        @JsonProperty("p")
        @NotNull
        private final String p;

        public static /* synthetic */ WebSocketBody copy$default(WebSocketBody webSocketBody, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = webSocketBody.p;
            }
            if ((i & 2) != 0) {
                str2 = webSocketBody.h;
            }
            return webSocketBody.copy(str, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getP() {
            return this.p;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getH() {
            return this.h;
        }

        @NotNull
        public final WebSocketBody copy(@JsonProperty("p") @NotNull String p, @JsonProperty("h") @NotNull String h) {
            return new WebSocketBody(p, h);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WebSocketBody)) {
                return false;
            }
            WebSocketBody webSocketBody = (WebSocketBody) other;
            return Intrinsics.areEqual(this.p, webSocketBody.p) && Intrinsics.areEqual(this.h, webSocketBody.h);
        }

        public int hashCode() {
            return (this.p.hashCode() * 31) + this.h.hashCode();
        }

        @NotNull
        public String toString() {
            return "WebSocketBody(p=" + this.p + ", h=" + this.h + ')';
        }

        public WebSocketBody(@JsonProperty("p") @NotNull String p, @JsonProperty("h") @NotNull String h) {
            this.p = p;
            this.h = h;
        }

        @NotNull
        public final String getP() {
            return this.p;
        }

        @NotNull
        public final String getH() {
            return this.h;
        }
    }

    /* JADX INFO: compiled from: StreamFlixWebSocketExtractor.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JQ\u0010\u001f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u00052\b\b\u0003\u0010\b\u001a\u00020\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0005HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/cncverse/StreamFlixWebSocketExtractor$EpisodeData;", "", "key", "", "link", "", "name", "overview", "runtime", "stillPath", "voteAverage", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;D)V", "getKey", "()I", "getLink", "()Ljava/lang/String;", "getName", "getOverview", "getRuntime", "getStillPath", "getVoteAverage", "()D", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "StreamFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class EpisodeData {

        @JsonProperty("key")
        private final int key;

        @JsonProperty("link")
        @NotNull
        private final String link;

        @JsonProperty("name")
        @NotNull
        private final String name;

        @JsonProperty("overview")
        @NotNull
        private final String overview;

        @JsonProperty("runtime")
        private final int runtime;

        @JsonProperty("still_path")
        @Nullable
        private final String stillPath;

        @JsonProperty("vote_average")
        private final double voteAverage;

        public static /* synthetic */ EpisodeData copy$default(EpisodeData episodeData, int i, String str, String str2, String str3, int i2, String str4, double d, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = episodeData.key;
            }
            if ((i3 & 2) != 0) {
                str = episodeData.link;
            }
            if ((i3 & 4) != 0) {
                str2 = episodeData.name;
            }
            if ((i3 & 8) != 0) {
                str3 = episodeData.overview;
            }
            if ((i3 & 16) != 0) {
                i2 = episodeData.runtime;
            }
            if ((i3 & 32) != 0) {
                str4 = episodeData.stillPath;
            }
            if ((i3 & 64) != 0) {
                d = episodeData.voteAverage;
            }
            double d2 = d;
            int i4 = i2;
            String str5 = str4;
            return episodeData.copy(i, str, str2, str3, i4, str5, d2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getKey() {
            return this.key;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLink() {
            return this.link;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getOverview() {
            return this.overview;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getRuntime() {
            return this.runtime;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getStillPath() {
            return this.stillPath;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final double getVoteAverage() {
            return this.voteAverage;
        }

        @NotNull
        public final EpisodeData copy(@JsonProperty("key") int key, @JsonProperty("link") @NotNull String link, @JsonProperty("name") @NotNull String name, @JsonProperty("overview") @NotNull String overview, @JsonProperty("runtime") int runtime, @JsonProperty("still_path") @Nullable String stillPath, @JsonProperty("vote_average") double voteAverage) {
            return new EpisodeData(key, link, name, overview, runtime, stillPath, voteAverage);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EpisodeData)) {
                return false;
            }
            EpisodeData episodeData = (EpisodeData) other;
            return this.key == episodeData.key && Intrinsics.areEqual(this.link, episodeData.link) && Intrinsics.areEqual(this.name, episodeData.name) && Intrinsics.areEqual(this.overview, episodeData.overview) && this.runtime == episodeData.runtime && Intrinsics.areEqual(this.stillPath, episodeData.stillPath) && Double.compare(this.voteAverage, episodeData.voteAverage) == 0;
        }

        public int hashCode() {
            return (((((((((((this.key * 31) + this.link.hashCode()) * 31) + this.name.hashCode()) * 31) + this.overview.hashCode()) * 31) + this.runtime) * 31) + (this.stillPath == null ? 0 : this.stillPath.hashCode())) * 31) + C0009xf809d861.m4m(this.voteAverage);
        }

        @NotNull
        public String toString() {
            return "EpisodeData(key=" + this.key + ", link=" + this.link + ", name=" + this.name + ", overview=" + this.overview + ", runtime=" + this.runtime + ", stillPath=" + this.stillPath + ", voteAverage=" + this.voteAverage + ')';
        }

        public EpisodeData(@JsonProperty("key") int key, @JsonProperty("link") @NotNull String link, @JsonProperty("name") @NotNull String name, @JsonProperty("overview") @NotNull String overview, @JsonProperty("runtime") int runtime, @JsonProperty("still_path") @Nullable String stillPath, @JsonProperty("vote_average") double voteAverage) {
            this.key = key;
            this.link = link;
            this.name = name;
            this.overview = overview;
            this.runtime = runtime;
            this.stillPath = stillPath;
            this.voteAverage = voteAverage;
        }

        public final int getKey() {
            return this.key;
        }

        @NotNull
        public final String getLink() {
            return this.link;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getOverview() {
            return this.overview;
        }

        public final int getRuntime() {
            return this.runtime;
        }

        @Nullable
        public final String getStillPath() {
            return this.stillPath;
        }

        public final double getVoteAverage() {
            return this.voteAverage;
        }
    }

    /* JADX INFO: renamed from: com.cncverse.StreamFlixWebSocketExtractor$getEpisodesFromWebSocket$2 */
    /* JADX INFO: compiled from: StreamFlixWebSocketExtractor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u0018\u00010\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "", "Lcom/cncverse/StreamFlixWebSocketExtractor$EpisodeData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.StreamFlixWebSocketExtractor$getEpisodesFromWebSocket$2", f = "StreamFlixWebSocketExtractor.kt", i = {0}, l = {242}, m = "invokeSuspend", n = {"$i$f$suspendCancellableCoroutine"}, nl = {252}, s = {"I$1"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamFlixWebSocketExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamFlixWebSocketExtractor.kt\ncom/cncverse/StreamFlixWebSocketExtractor$getEpisodesFromWebSocket$2\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,241:1\n426#2,11:242\n*S KotlinDebug\n*F\n+ 1 StreamFlixWebSocketExtractor.kt\ncom/cncverse/StreamFlixWebSocketExtractor$getEpisodesFromWebSocket$2\n*L\n47#1:242,11\n*E\n"})
    static final class C00112 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<Integer, ? extends Map<Integer, ? extends EpisodeData>>>, Object> {
        final /* synthetic */ String $movieKey;
        final /* synthetic */ int $totalSeasons;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00112(int i, String str, Continuation<? super C00112> continuation) {
            super(2, continuation);
            this.$totalSeasons = i;
            this.$movieKey = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return StreamFlixWebSocketExtractor.this.new C00112(this.$totalSeasons, this.$movieKey, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Map<Integer, ? extends Map<Integer, EpisodeData>>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    StreamFlixWebSocketExtractor streamFlixWebSocketExtractor = StreamFlixWebSocketExtractor.this;
                    final int i = this.$totalSeasons;
                    final String str = this.$movieKey;
                    this.L$0 = streamFlixWebSocketExtractor;
                    this.L$1 = str;
                    this.I$0 = i;
                    this.I$1 = 0;
                    this.label = 1;
                    Continuation uCont$iv = (Continuation) this;
                    CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
                    cancellableContinuationImpl.initCancellability();
                    final CancellableContinuation continuation = cancellableContinuationImpl;
                    Request request = new Request.Builder().url("wss://chilflix-410be-default-rtdb.asia-southeast1.firebasedatabase.app/.ws?ns=chilflix-410be-default-rtdb&v=5").build();
                    final WebSocket webSocket = streamFlixWebSocketExtractor.client.newWebSocket(request, new WebSocketListener() { // from class: com.cncverse.StreamFlixWebSocketExtractor$getEpisodesFromWebSocket$2$1$webSocket$1
                        private int expectedResponses;
                        private boolean receivedInitialData;
                        private int responsesReceived;
                        private int seasonsCompleted;
                        private Map<Integer, Map<Integer, StreamFlixWebSocketExtractor.EpisodeData>> seasonsData = new LinkedHashMap();
                        private int currentSeason = 1;
                        private StringBuilder messageBuffer = new StringBuilder();

                        public void onOpen(WebSocket webSocket2, Response response) {
                            Log.INSTANCE.d("StreamFlix", "WebSocket opened, requesting " + i + " seasons");
                            StreamFlixWebSocketExtractor.WebSocketRequest requestData = new StreamFlixWebSocketExtractor.WebSocketRequest("d", new StreamFlixWebSocketExtractor.WebSocketData("q", this.currentSeason, new StreamFlixWebSocketExtractor.WebSocketBody("Data/" + str + "/seasons/" + this.currentSeason + "/episodes", "")));
                            String requestJson = AppUtils.INSTANCE.toJson(requestData);
                            webSocket2.send(requestJson);
                            Log.INSTANCE.d("StreamFlix", "Sent request for season " + this.currentSeason + ": " + requestJson);
                        }

                        public void onMessage(WebSocket webSocket2, String text) {
                            Log.INSTANCE.d("StreamFlix", "Received: " + StringsKt.take(text, 100) + (text.length() > 100 ? "..." : ""));
                            try {
                                int number = Integer.parseInt(StringsKt.trim(text).toString());
                                if (this.expectedResponses == 0) {
                                    this.expectedResponses = number;
                                    Log.INSTANCE.d("StreamFlix", "Expecting " + this.expectedResponses + " data responses for season " + this.currentSeason);
                                }
                            } catch (NumberFormatException e) {
                                this.messageBuffer.append(text);
                                String fullMessage = this.messageBuffer.toString();
                                try {
                                    JsonNode jsonObject = MainAPIKt.getMapper().readTree(fullMessage);
                                    StringsKt.clear(this.messageBuffer);
                                    processJsonMessage(jsonObject, webSocket2);
                                } catch (Exception e2) {
                                    if (fullMessage.length() > 100000) {
                                        Log.INSTANCE.e("StreamFlix", "Message too large, clearing buffer");
                                        StringsKt.clear(this.messageBuffer);
                                        if (continuation.isActive()) {
                                            Continuation continuation2 = continuation;
                                            Result.Companion companion = Result.Companion;
                                            continuation2.resumeWith(Result.constructor-impl(this.seasonsData));
                                            webSocket2.close(1000, "Message too large");
                                        }
                                    }
                                }
                            }
                        }

                        private final void processJsonMessage(JsonNode jsonObject, WebSocket webSocket2) {
                            Iterator $this$forEach$iv;
                            Object obj;
                            String value$iv;
                            Object objDecodeFromString;
                            List groupValues;
                            String str2;
                            Integer intOrNull;
                            String strAsText;
                            try {
                                if (jsonObject.has("t") && Intrinsics.areEqual(jsonObject.get("t").asText(), "d")) {
                                    JsonNode data = jsonObject.get("d");
                                    JsonNode bData = data.get("b");
                                    String path = "";
                                    if (data.has("r") && bData != null && bData.has("s")) {
                                        String status = bData.get("s").asText();
                                        if (Intrinsics.areEqual(status, "ok")) {
                                            Log.INSTANCE.d("StreamFlix", "Received completion status for season " + this.currentSeason);
                                            this.seasonsCompleted++;
                                            Log.INSTANCE.d("StreamFlix", "Season " + this.currentSeason + " complete via status (" + this.seasonsCompleted + '/' + i + ')');
                                            if (this.seasonsCompleted < i) {
                                                this.currentSeason++;
                                                this.expectedResponses = 0;
                                                this.responsesReceived = 0;
                                                StreamFlixWebSocketExtractor.WebSocketRequest requestData = new StreamFlixWebSocketExtractor.WebSocketRequest("d", new StreamFlixWebSocketExtractor.WebSocketData("q", this.currentSeason, new StreamFlixWebSocketExtractor.WebSocketBody("Data/" + str + "/seasons/" + this.currentSeason + "/episodes", "")));
                                                webSocket2.send(AppUtils.INSTANCE.toJson(requestData));
                                                Log.INSTANCE.d("StreamFlix", "Requesting season " + this.currentSeason);
                                                return;
                                            }
                                            Log.INSTANCE.d("StreamFlix", "All " + i + " seasons completed");
                                            if (continuation.isActive()) {
                                                Continuation continuation2 = continuation;
                                                Result.Companion companion = Result.Companion;
                                                continuation2.resumeWith(Result.constructor-impl(this.seasonsData));
                                                webSocket2.close(1000, "Done");
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    if (bData != null && bData.has("d")) {
                                        JsonNode episodes = bData.get("d");
                                        JsonNode jsonNode = bData.get("p");
                                        if (jsonNode != null && (strAsText = jsonNode.asText()) != null) {
                                            path = strAsText;
                                        }
                                        int i2 = 2;
                                        List list = null;
                                        MatchResult seasonMatch = Regex.find$default(new Regex("seasons/(\\d+)/episodes"), path, 0, 2, (Object) null);
                                        int seasonNumber = (seasonMatch == null || (groupValues = seasonMatch.getGroupValues()) == null || (str2 = (String) groupValues.get(1)) == null || (intOrNull = StringsKt.toIntOrNull(str2)) == null) ? this.currentSeason : intOrNull.intValue();
                                        Map episodeMap = new LinkedHashMap();
                                        if (episodes != null && ($this$forEach$iv = episodes.fields()) != null) {
                                            while ($this$forEach$iv.hasNext()) {
                                                Object element$iv = $this$forEach$iv.next();
                                                Map.Entry entry = (Map.Entry) element$iv;
                                                try {
                                                    AppUtils appUtils = AppUtils.INSTANCE;
                                                    String value$iv2 = ((JsonNode) entry.getValue()).toString();
                                                    try {
                                                        Result.Companion companion2 = Result.Companion;
                                                        KType kTypeTypeOf = Reflection.typeOf(StreamFlixWebSocketExtractor.EpisodeData.class);
                                                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                                    } catch (Throwable th) {
                                                        Result.Companion companion3 = Result.Companion;
                                                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                                                    }
                                                    if (Result.exceptionOrNull-impl(obj) != null) {
                                                        try {
                                                            Result.Companion companion4 = Result.Companion;
                                                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(StreamFlixWebSocketExtractor.EpisodeData.class), list, i2, list));
                                                        } catch (Throwable th2) {
                                                            Result.Companion companion5 = Result.Companion;
                                                            obj = Result.constructor-impl(ResultKt.createFailure(th2));
                                                        }
                                                    }
                                                    if (Result.isFailure-impl(obj)) {
                                                        obj = list;
                                                    }
                                                    DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                                                    if (deserializationStrategy != null) {
                                                        try {
                                                            value$iv = value$iv2;
                                                            try {
                                                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                                                            } catch (SerializationException e) {
                                                                e$iv = e;
                                                                ArchComponentExtKt.logError((Throwable) e$iv);
                                                                ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                                                String content$iv$iv = value$iv;
                                                                objDecodeFromString = $this$readValue$iv$iv.readValue(content$iv$iv, new TypeReference<StreamFlixWebSocketExtractor.EpisodeData>() { // from class: com.cncverse.StreamFlixWebSocketExtractor$getEpisodesFromWebSocket$2$1$webSocket$1$processJsonMessage$lambda$0$$inlined$parseJson$1
                                                                });
                                                            } catch (Throwable th3) {
                                                                ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                                                String content$iv$iv2 = value$iv;
                                                                objDecodeFromString = $this$readValue$iv$iv2.readValue(content$iv$iv2, new TypeReference<StreamFlixWebSocketExtractor.EpisodeData>() { // from class: com.cncverse.StreamFlixWebSocketExtractor$getEpisodesFromWebSocket$2$1$webSocket$1$processJsonMessage$lambda$0$$inlined$parseJson$1
                                                                });
                                                            }
                                                        } catch (SerializationException e2) {
                                                            e$iv = e2;
                                                            value$iv = value$iv2;
                                                        } catch (Throwable th4) {
                                                            value$iv = value$iv2;
                                                        }
                                                        StreamFlixWebSocketExtractor.EpisodeData episodeData = (StreamFlixWebSocketExtractor.EpisodeData) objDecodeFromString;
                                                        episodeMap.put(Integer.valueOf(Integer.parseInt((String) entry.getKey())), episodeData);
                                                        Log.INSTANCE.d("StreamFlix", "Parsed episode " + ((String) entry.getKey()) + ": " + episodeData.getName());
                                                        i2 = 2;
                                                        list = null;
                                                    } else {
                                                        value$iv = value$iv2;
                                                    }
                                                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                                    String content$iv$iv3 = value$iv;
                                                    objDecodeFromString = $this$readValue$iv$iv3.readValue(content$iv$iv3, new TypeReference<StreamFlixWebSocketExtractor.EpisodeData>() { // from class: com.cncverse.StreamFlixWebSocketExtractor$getEpisodesFromWebSocket$2$1$webSocket$1$processJsonMessage$lambda$0$$inlined$parseJson$1
                                                    });
                                                    StreamFlixWebSocketExtractor.EpisodeData episodeData2 = (StreamFlixWebSocketExtractor.EpisodeData) objDecodeFromString;
                                                    episodeMap.put(Integer.valueOf(Integer.parseInt((String) entry.getKey())), episodeData2);
                                                    Log.INSTANCE.d("StreamFlix", "Parsed episode " + ((String) entry.getKey()) + ": " + episodeData2.getName());
                                                } catch (Exception e3) {
                                                    Log.INSTANCE.e("StreamFlix", "Error parsing episode: " + e3.getMessage());
                                                }
                                                i2 = 2;
                                                list = null;
                                            }
                                        }
                                        if (!episodeMap.isEmpty()) {
                                            LinkedHashMap linkedHashMap = this.seasonsData.get(Integer.valueOf(seasonNumber));
                                            if (linkedHashMap == null) {
                                                linkedHashMap = new LinkedHashMap();
                                            }
                                            Map<Integer, StreamFlixWebSocketExtractor.EpisodeData> mutableMap = MapsKt.toMutableMap(linkedHashMap);
                                            mutableMap.putAll(episodeMap);
                                            this.seasonsData.put(Integer.valueOf(seasonNumber), mutableMap);
                                            this.responsesReceived++;
                                            Log.INSTANCE.d("StreamFlix", "Added " + episodeMap.size() + " episodes for season " + seasonNumber + " (" + mutableMap.size() + " total) (" + this.responsesReceived + '/' + this.expectedResponses + ')');
                                            if (this.expectedResponses == 0) {
                                                Log.INSTANCE.d("StreamFlix", "No expected count yet, waiting for more data");
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    if (!this.receivedInitialData) {
                                        this.receivedInitialData = true;
                                    } else if (continuation.isActive()) {
                                        Continuation continuation3 = continuation;
                                        Result.Companion companion6 = Result.Companion;
                                        continuation3.resumeWith(Result.constructor-impl(this.seasonsData));
                                        webSocket2.close(1000, "Done");
                                    }
                                }
                            } catch (Exception e4) {
                                Log.INSTANCE.e("StreamFlix", "Error processing JSON message: " + e4.getMessage());
                                if (continuation.isActive()) {
                                    Continuation continuation4 = continuation;
                                    Result.Companion companion7 = Result.Companion;
                                    continuation4.resumeWith(Result.constructor-impl(this.seasonsData));
                                    webSocket2.close(1000, "Error");
                                }
                            }
                        }

                        public void onFailure(WebSocket webSocket2, Throwable t, Response response) {
                            Log.INSTANCE.e("StreamFlix", "WebSocket failed: " + t.getMessage());
                            if (continuation.isActive()) {
                                Continuation continuation2 = continuation;
                                Result.Companion companion = Result.Companion;
                                continuation2.resumeWith(Result.constructor-impl(MapsKt.emptyMap()));
                            }
                        }

                        public void onClosing(WebSocket webSocket2, int code, String reason) {
                            Log.INSTANCE.d("StreamFlix", "WebSocket closing: " + code + ' ' + reason);
                            if (continuation.isActive()) {
                                Continuation continuation2 = continuation;
                                Result.Companion companion = Result.Companion;
                                continuation2.resumeWith(Result.constructor-impl(this.seasonsData));
                            }
                        }
                    });
                    continuation.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.cncverse.StreamFlixWebSocketExtractor$getEpisodesFromWebSocket$2$1$1
                        public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                            invoke((Throwable) p1);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Throwable it) {
                            webSocket.close(1000, "Cancelled");
                        }
                    });
                    Object result = cancellableContinuationImpl.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended((Continuation) this);
                    }
                    if (result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return result;
                case 1:
                    int i2 = this.I$1;
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public static /* synthetic */ Object getEpisodesFromWebSocket$default(StreamFlixWebSocketExtractor streamFlixWebSocketExtractor, String str, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1;
        }
        return streamFlixWebSocketExtractor.getEpisodesFromWebSocket(str, i, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public final Object getEpisodesFromWebSocket(@NotNull String movieKey, int totalSeasons, @NotNull Continuation<? super Map<Integer, ? extends Map<Integer, EpisodeData>>> continuation) {
        C00101 c00101;
        Object objWithTimeoutOrNull;
        if (continuation instanceof C00101) {
            c00101 = (C00101) continuation;
            if ((c00101.label & Integer.MIN_VALUE) != 0) {
                c00101.label -= Integer.MIN_VALUE;
            } else {
                c00101 = new C00101(continuation);
            }
        } else {
            c00101 = new C00101(continuation);
        }
        Object $result = c00101.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00101.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                C00112 c00112 = new C00112(totalSeasons, movieKey, null);
                c00101.L$0 = SpillingKt.nullOutSpilledVariable(movieKey);
                c00101.I$0 = totalSeasons;
                c00101.label = 1;
                objWithTimeoutOrNull = TimeoutKt.withTimeoutOrNull(30000L, c00112, c00101);
                if (objWithTimeoutOrNull == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                int totalSeasons2 = c00101.I$0;
                ResultKt.throwOnFailure($result);
                objWithTimeoutOrNull = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Map map = (Map) objWithTimeoutOrNull;
        if (map != null) {
            return map;
        }
        return MapsKt.emptyMap();
    }
}
