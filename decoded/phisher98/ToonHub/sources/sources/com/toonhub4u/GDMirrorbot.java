package com.toonhub4u;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.net.URI;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/ToonHub/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0003\u001c\u001d\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00120\u0016H\u0096@¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/toonhub4u/GDMirrorbot;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBaseUrl", "EmbedResponse", "EmbedData", "HelperResponse", "ToonHub"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/toonhub4u/GDMirrorbot\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 6 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,247:1\n1#2:248\n1#2:250\n1#2:274\n63#3:249\n64#3,15:251\n63#3:273\n64#3,15:275\n50#4:266\n43#4:267\n50#4:290\n43#4:291\n73#5,5:268\n2068#6,2:292\n*S KotlinDebug\n*F\n+ 1 Extractor.kt\ncom/toonhub4u/GDMirrorbot\n*L\n148#1:250\n173#1:274\n148#1:249\n148#1:251,15\n173#1:273\n173#1:275,15\n148#1:266\n148#1:267\n173#1:290\n173#1:291\n164#1:268,5\n187#1:292,2\n*E\n"})
public class GDMirrorbot extends ExtractorApi {

    @NotNull
    private String name = "GDMirrorbot";

    @NotNull
    private String mainUrl = "https://gdmirrorbot.nl";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.toonhub4u.GDMirrorbot$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.toonhub4u.GDMirrorbot", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}, l = {104, 107, 145, 161, 207, 216, 225}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "$this", "url", "referer", "subtitleCallback", "callback", "$this", "url", "referer", "subtitleCallback", "callback", "pageText", "finalId", "myKey", "idType", "baseUrl", "hostUrl", "apiUrl", "$this", "url", "referer", "subtitleCallback", "callback", "sid", "host", "$this", "url", "referer", "subtitleCallback", "callback", "sid", "host", "response", "decodedMresult", "$this$forEach$iv", "element$iv", "key", "path", "friendlyName", "fullUrl", "base", "$this", "url", "referer", "subtitleCallback", "callback", "sid", "host", "response", "decodedMresult", "$this$forEach$iv", "element$iv", "key", "path", "friendlyName", "fullUrl", "base", "$this", "url", "referer", "subtitleCallback", "callback", "sid", "host", "response", "decodedMresult", "$this$forEach$iv", "element$iv", "key", "path", "friendlyName", "fullUrl", "base"}, nl = {102, 111, 148, 164, 216, 225, 233}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GDMirrorbot.getUrl$suspendImpl(GDMirrorbot.this, null, null, null, null, (Continuation) this);
        }
    }

    @Nullable
    public Object getUrl(@NotNull String str, @Nullable String str2, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        return getUrl$suspendImpl(this, str, str2, function1, function2, continuation);
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u001c\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J'\u0010\f\u001a\u00020\u00002\u001c\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R+\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/toonhub4u/GDMirrorbot$EmbedResponse;", "", "data", "", "Lcom/toonhub4u/GDMirrorbot$EmbedData;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/List;)V", "getData", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ToonHub"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class EmbedResponse {

        @JsonProperty("data")
        @NotNull
        private final List<EmbedData> data;

        /* JADX WARN: Illegal instructions before constructor call */
        public EmbedResponse() {
            List list = null;
            this(list, 1, list);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ EmbedResponse copy$default(EmbedResponse embedResponse, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = embedResponse.data;
            }
            return embedResponse.copy(list);
        }

        @NotNull
        public final List<EmbedData> component1() {
            return this.data;
        }

        @NotNull
        public final EmbedResponse copy(@JsonProperty("data") @NotNull List<EmbedData> data) {
            return new EmbedResponse(data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof EmbedResponse) && Intrinsics.areEqual(this.data, ((EmbedResponse) other).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "EmbedResponse(data=" + this.data + ')';
        }

        public EmbedResponse(@JsonProperty("data") @NotNull List<EmbedData> list) {
            this.data = list;
        }

        public /* synthetic */ EmbedResponse(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
        }

        @NotNull
        public final List<EmbedData> getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/toonhub4u/GDMirrorbot$EmbedData;", "", "fileslug", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/lang/String;)V", "getFileslug", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "ToonHub"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class EmbedData {

        @JsonProperty("fileslug")
        @Nullable
        private final String fileslug;

        /* JADX WARN: Illegal instructions before constructor call */
        public EmbedData() {
            String str = null;
            this(str, 1, str);
        }

        public static /* synthetic */ EmbedData copy$default(EmbedData embedData, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = embedData.fileslug;
            }
            return embedData.copy(str);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFileslug() {
            return this.fileslug;
        }

        @NotNull
        public final EmbedData copy(@JsonProperty("fileslug") @Nullable String fileslug) {
            return new EmbedData(fileslug);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof EmbedData) && Intrinsics.areEqual(this.fileslug, ((EmbedData) other).fileslug);
        }

        public int hashCode() {
            if (this.fileslug == null) {
                return 0;
            }
            return this.fileslug.hashCode();
        }

        @NotNull
        public String toString() {
            return "EmbedData(fileslug=" + this.fileslug + ')';
        }

        public EmbedData(@JsonProperty("fileslug") @Nullable String fileslug) {
            this.fileslug = fileslug;
        }

        public /* synthetic */ EmbedData(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        @Nullable
        public final String getFileslug() {
            return this.fileslug;
        }
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\"\b\u0003\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\"\b\u0003\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\tHÆ\u0003Jk\u0010\u0014\u001a\u00020\u00002\"\b\u0003\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00022\"\b\u0003\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\bHÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0004HÖ\u0081\u0004R1\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR1\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR'\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u0092\u0002\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/toonhub4u/GDMirrorbot$HelperResponse;", "", "siteUrls", "", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "siteFriendlyNames", "mresult", "Lcom/fasterxml/jackson/databind/JsonNode;", "<init>", "(Ljava/util/Map;Ljava/util/Map;Lcom/fasterxml/jackson/databind/JsonNode;)V", "getSiteUrls", "()Ljava/util/Map;", "getSiteFriendlyNames", "getMresult", "()Lcom/fasterxml/jackson/databind/JsonNode;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ToonHub"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class HelperResponse {

        @JsonProperty("mresult")
        @Nullable
        private final JsonNode mresult;

        @JsonProperty("siteFriendlyNames")
        @NotNull
        private final Map<String, String> siteFriendlyNames;

        @JsonProperty("siteUrls")
        @NotNull
        private final Map<String, String> siteUrls;

        public HelperResponse() {
            this(null, null, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HelperResponse copy$default(HelperResponse helperResponse, Map map, Map map2, JsonNode jsonNode, int i, Object obj) {
            if ((i & 1) != 0) {
                map = helperResponse.siteUrls;
            }
            if ((i & 2) != 0) {
                map2 = helperResponse.siteFriendlyNames;
            }
            if ((i & 4) != 0) {
                jsonNode = helperResponse.mresult;
            }
            return helperResponse.copy(map, map2, jsonNode);
        }

        @NotNull
        public final Map<String, String> component1() {
            return this.siteUrls;
        }

        @NotNull
        public final Map<String, String> component2() {
            return this.siteFriendlyNames;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final JsonNode getMresult() {
            return this.mresult;
        }

        @NotNull
        public final HelperResponse copy(@JsonProperty("siteUrls") @NotNull Map<String, String> siteUrls, @JsonProperty("siteFriendlyNames") @NotNull Map<String, String> siteFriendlyNames, @JsonProperty("mresult") @Nullable JsonNode mresult) {
            return new HelperResponse(siteUrls, siteFriendlyNames, mresult);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HelperResponse)) {
                return false;
            }
            HelperResponse helperResponse = (HelperResponse) other;
            return Intrinsics.areEqual(this.siteUrls, helperResponse.siteUrls) && Intrinsics.areEqual(this.siteFriendlyNames, helperResponse.siteFriendlyNames) && Intrinsics.areEqual(this.mresult, helperResponse.mresult);
        }

        public int hashCode() {
            return (((this.siteUrls.hashCode() * 31) + this.siteFriendlyNames.hashCode()) * 31) + (this.mresult == null ? 0 : this.mresult.hashCode());
        }

        @NotNull
        public String toString() {
            return "HelperResponse(siteUrls=" + this.siteUrls + ", siteFriendlyNames=" + this.siteFriendlyNames + ", mresult=" + this.mresult + ')';
        }

        public HelperResponse(@JsonProperty("siteUrls") @NotNull Map<String, String> map, @JsonProperty("siteFriendlyNames") @NotNull Map<String, String> map2, @JsonProperty("mresult") @Nullable JsonNode mresult) {
            this.siteUrls = map;
            this.siteFriendlyNames = map2;
            this.mresult = mresult;
        }

        public /* synthetic */ HelperResponse(Map map, Map map2, JsonNode jsonNode, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? MapsKt.emptyMap() : map, (i & 2) != 0 ? MapsKt.emptyMap() : map2, (i & 4) != 0 ? null : jsonNode);
        }

        @NotNull
        public final Map<String, String> getSiteUrls() {
            return this.siteUrls;
        }

        @NotNull
        public final Map<String, String> getSiteFriendlyNames() {
            return this.siteFriendlyNames;
        }

        @Nullable
        public final JsonNode getMresult() {
            return this.mresult;
        }
    }

    /* JADX WARN: Code duplicated, block: B:201:0x086e  */
    /* JADX WARN: Code duplicated, block: B:203:0x0887  */
    /* JADX WARN: Code duplicated, block: B:205:0x0898  */
    /* JADX WARN: Code duplicated, block: B:242:0x0948  */
    /* JADX WARN: Code duplicated, block: B:243:0x094c A[Catch: Exception -> 0x0adc, TRY_LEAVE, TryCatch #14 {Exception -> 0x0adc, blocks: (B:223:0x0903, B:225:0x0908, B:243:0x094c, B:240:0x0940), top: B:329:0x0903 }] */
    /* JADX WARN: Code duplicated, block: B:248:0x09b0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:249:0x09b1  */
    /* JADX WARN: Code duplicated, block: B:259:0x0a31 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:260:0x0a32  */
    /* JADX WARN: Code duplicated, block: B:264:0x0a5c  */
    /* JADX WARN: Code duplicated, block: B:268:0x0a67  */
    /* JADX WARN: Code duplicated, block: B:271:0x0ab5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:272:0x0ab6  */
    /* JADX WARN: Code duplicated, block: B:293:0x0b9b A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:294:0x0ba4  */
    /* JADX WARN: Code duplicated, block: B:308:0x0a62 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0020  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x01cc: MOVE (r12 I:??[OBJECT, ARRAY] A[D('$i$a$-forEach-GDMirrorbot$getUrl$2' int)]) = (r11 I:??[OBJECT, ARRAY] A[D('friendlyName' java.lang.String)]), block:B:22:0x01b5 */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x01c7: MOVE (r18 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('key' java.lang.String)]) = (r12 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$i$a$-forEach-GDMirrorbot$getUrl$2' int)]), block:B:22:0x01b5 */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x01c9: MOVE (r22 I:??[OBJECT, ARRAY] A[D('decodedMresult' com.fasterxml.jackson.databind.JsonNode)]) = (r13 I:??[OBJECT, ARRAY] A[D('path' java.lang.String)]), block:B:22:0x01b5 */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x01d5: MOVE (r25 I:??[OBJECT, ARRAY] A[D('sid' java.lang.String)]) = (r14 I:??[OBJECT, ARRAY] A[D('base' java.lang.String)]), block:B:22:0x01b5 */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x01bb: MOVE (r0 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY] A[D('fullUrl' java.lang.String)]), block:B:22:0x01b5 */
    /* JADX WARN: Not initialized variable reg: 18, insn: 0x01c3: MOVE (r5 I:??[OBJECT, ARRAY] A[D('$this' com.toonhub4u.GDMirrorbot)]) = (r18 I:??[OBJECT, ARRAY] A[D('key' java.lang.String)]), block:B:22:0x01b5 */
    /* JADX WARN: Not initialized variable reg: 19, insn: 0x01bc: MOVE (r16 I:??[OBJECT, ARRAY]) = (r19 I:??[OBJECT, ARRAY] A[D('element$iv' java.lang.Object)]), block:B:22:0x01b5 */
    /* JADX WARN: Not initialized variable reg: 20, insn: 0x01cd: MOVE (r8 I:??[OBJECT, ARRAY]) = (r20 I:??[OBJECT, ARRAY]), block:B:22:0x01b5 */
    /* JADX WARN: Not initialized variable reg: 21, insn: 0x01cf: MOVE (r20 I:??[OBJECT, ARRAY]) = (r21 I:??[OBJECT, ARRAY] A[D('$this$forEach$iv' java.lang.Iterable)]), block:B:22:0x01b5 */
    /* JADX WARN: Not initialized variable reg: 22, insn: 0x01c5: MOVE (r10 I:??[OBJECT, ARRAY]) = (r22 I:??[OBJECT, ARRAY] A[D('decodedMresult' com.fasterxml.jackson.databind.JsonNode)]), block:B:22:0x01b5 */
    /* JADX WARN: Not initialized variable reg: 23, insn: 0x01d7: MOVE (r14 I:??[OBJECT, ARRAY] A[D('base' java.lang.String)]) = (r23 I:??[OBJECT, ARRAY] A[D('response' com.toonhub4u.GDMirrorbot$HelperResponse)]), block:B:22:0x01b5 */
    /* JADX WARN: Not initialized variable reg: 24, insn: 0x01d1: MOVE (r21 I:??[OBJECT, ARRAY] A[D('$this$forEach$iv' java.lang.Iterable)]) = (r24 I:??[OBJECT, ARRAY] A[D('host' java.lang.String)]), block:B:22:0x01b5 */
    /* JADX WARN: Not initialized variable reg: 25, insn: 0x01d3: MOVE (r11 I:??[OBJECT, ARRAY] A[D('friendlyName' java.lang.String)]) = (r25 I:??[OBJECT, ARRAY] A[D('sid' java.lang.String)]), block:B:22:0x01b5 */
    /* JADX WARN: Path cross not found for [B:345:0x0807, B:196:0x081c], limit reached: 328 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v39 */
    /* JADX WARN: Type inference failed for: r7v4, types: [com.toonhub4u.GDMirrorbot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v41 */
    /* JADX WARN: Type inference failed for: r7v42 */
    /* JADX WARN: Type inference failed for: r7v43 */
    /* JADX WARN: Type inference failed for: r7v48 */
    /* JADX WARN: Type inference failed for: r7v49 */
    /* JADX WARN: Type inference failed for: r7v50 */
    /* JADX WARN: Type inference failed for: r7v51 */
    /* JADX WARN: Type inference failed for: r7v52 */
    /* JADX WARN: Type inference failed for: r7v53 */
    /* JADX WARN: Type inference failed for: r7v54 */
    /* JADX WARN: Type inference failed for: r7v55 */
    /* JADX WARN: Type inference failed for: r7v56 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:272:0x0ab6 -> B:273:0x0ac0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:287:0x0b2b -> B:288:0x0b72). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:296:0x0bb1 -> B:297:0x0bb9). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.toonhub4u.GDMirrorbot r36, java.lang.String r37, java.lang.String r38, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r39, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r40, kotlin.coroutines.Continuation<? super kotlin.Unit> r41) {
        /*
            Method dump skipped, instruction units count: 3092
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.toonhub4u.GDMirrorbot.getUrl$suspendImpl(com.toonhub4u.GDMirrorbot, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String getBaseUrl(String url) {
        URI it = new URI(url);
        return it.getScheme() + "://" + it.getHost();
    }
}
