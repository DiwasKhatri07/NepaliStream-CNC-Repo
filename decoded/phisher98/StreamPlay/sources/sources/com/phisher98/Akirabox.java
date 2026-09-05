package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/phisher98/Akirabox;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AkiraboxRes", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/phisher98/Akirabox\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,4003:1\n73#2,5:4004\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/phisher98/Akirabox\n*L\n2342#1:4004,5\n*E\n"})
public final class Akirabox extends ExtractorApi {

    @NotNull
    private final String name = "Akirabox";

    @NotNull
    private final String mainUrl = "https://akirabox.com";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.phisher98.Akirabox$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Akirabox", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {2342, 2346}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "id", "url", "referer", "subtitleCallback", "callback", "id", "m3u8"}, nl = {4004, 2345}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Akirabox.this.getUrl(null, null, null, null, (Continuation) this);
        }
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0167  */
    /* JADX WARN: Code duplicated, block: B:26:0x016d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0172  */
    /* JADX WARN: Code duplicated, block: B:30:0x01b6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:33:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C00001 c00001;
        Akirabox akirabox;
        String id;
        Object obj;
        int i;
        Object objPost$default;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        String url2;
        Object safe;
        AkiraboxRes akiraboxRes;
        String m3u8;
        Object objNewExtractorLink;
        String m3u9;
        Function1<? super SubtitleFile, Unit> function5;
        Function1<? super ExtractorLink, Unit> function6;
        Function1<? super ExtractorLink, Unit> function7;
        String m3u10;
        if (continuation instanceof C00001) {
            c00001 = (C00001) continuation;
            if ((c00001.label & Integer.MIN_VALUE) != 0) {
                c00001.label -= Integer.MIN_VALUE;
                akirabox = this;
            } else {
                akirabox = this;
                c00001 = akirabox.new C00001(continuation);
            }
        } else {
            akirabox = this;
            c00001 = akirabox.new C00001(continuation);
        }
        C00001 c00002 = c00001;
        Object $result = c00002.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00002.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String id2 = StringsKt.substringBefore$default(StringsKt.substringAfter$default(url, akirabox.getMainUrl() + '/', (String) null, 2, (Object) null), "/", (String) null, 2, (Object) null);
                Requests app = MainActivityKt.getApp();
                String str = akirabox.getMainUrl() + '/' + id2 + "/file/generate";
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("x-csrf-token", "L57KI068FpaS5Ttgo1W20tQMlFhtEwCJGkOgIdSH"));
                c00002.L$0 = url;
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                c00002.L$3 = function2;
                c00002.L$4 = SpillingKt.nullOutSpilledVariable(id2);
                c00002.label = 1;
                id = id2;
                obj = coroutine_suspended;
                i = 2;
                objPost$default = Requests.post$default(app, str, mapMapOf, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 65532, (Object) null);
                c00002 = c00002;
                if (objPost$default == obj) {
                    return obj;
                }
                referer2 = referer;
                function3 = function1;
                function4 = function2;
                url2 = url;
                NiceResponse this_$iv = (NiceResponse) objPost$default;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(AkiraboxRes.class));
                    break;
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                akiraboxRes = (AkiraboxRes) safe;
                if (akiraboxRes != null) {
                    m3u8 = akiraboxRes.getDownloadLink();
                } else {
                    m3u8 = null;
                }
                if (m3u8 != null) {
                    String name = akirabox.getName();
                    String name2 = akirabox.getName();
                    ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                    C00012 c00012 = new C00012(url2, null);
                    c00002.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00002.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00002.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00002.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                    c00002.L$4 = SpillingKt.nullOutSpilledVariable(id);
                    c00002.L$5 = SpillingKt.nullOutSpilledVariable(m3u8);
                    c00002.L$6 = function4;
                    c00002.label = i;
                    objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, name2, m3u8, extractorLinkType, c00012, c00002);
                    if (objNewExtractorLink == obj) {
                        return obj;
                    }
                    m3u9 = m3u8;
                    function5 = function3;
                    function6 = function4;
                    function7 = function6;
                    m3u10 = id;
                    function6.invoke(objNewExtractorLink);
                }
                return Unit.INSTANCE;
            case 1:
                String id3 = (String) c00002.L$4;
                Function1<? super ExtractorLink, Unit> function8 = (Function1) c00002.L$3;
                Function1<? super SubtitleFile, Unit> function9 = (Function1) c00002.L$2;
                referer2 = (String) c00002.L$1;
                String url3 = (String) c00002.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                id = id3;
                function4 = function8;
                function3 = function9;
                objPost$default = $result;
                i = 2;
                url2 = url3;
                NiceResponse this_$iv2 = (NiceResponse) objPost$default;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(AkiraboxRes.class));
                akiraboxRes = (AkiraboxRes) safe;
                if (akiraboxRes != null) {
                    m3u8 = akiraboxRes.getDownloadLink();
                } else {
                    m3u8 = null;
                }
                if (m3u8 != null) {
                    String name3 = akirabox.getName();
                    String name4 = akirabox.getName();
                    ExtractorLinkType extractorLinkType2 = ExtractorLinkType.M3U8;
                    C00012 c00013 = new C00012(url2, null);
                    c00002.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00002.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00002.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00002.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                    c00002.L$4 = SpillingKt.nullOutSpilledVariable(id);
                    c00002.L$5 = SpillingKt.nullOutSpilledVariable(m3u8);
                    c00002.L$6 = function4;
                    c00002.label = i;
                    objNewExtractorLink = ExtractorApiKt.newExtractorLink(name3, name4, m3u8, extractorLinkType2, c00013, c00002);
                    if (objNewExtractorLink == obj) {
                        return obj;
                    }
                    m3u9 = m3u8;
                    function5 = function3;
                    function6 = function4;
                    function7 = function6;
                    m3u10 = id;
                    function6.invoke(objNewExtractorLink);
                }
                return Unit.INSTANCE;
            case 2:
                function6 = (Function1) c00002.L$6;
                m3u9 = (String) c00002.L$5;
                m3u10 = (String) c00002.L$4;
                function7 = (Function1) c00002.L$3;
                function5 = (Function1) c00002.L$2;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink = $result;
                function6.invoke(objNewExtractorLink);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Akirabox$getUrl$2 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Akirabox$getUrl$2", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00012 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $url;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00012(String str, Continuation<? super C00012> continuation) {
            super(2, continuation);
            this.$url = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00012 = new C00012(this.$url, continuation);
            c00012.L$0 = obj;
            return c00012;
        }

        public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
            return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newExtractorLink.setReferer(this.$url);
                    $this$newExtractorLink.setQuality(Qualities.P1080.getValue());
                    $this$newExtractorLink.setHeaders($this$newExtractorLink.getHeaders());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/phisher98/Akirabox$AkiraboxRes;", "", "downloadLink", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "download_link", "<init>", "(Ljava/lang/String;)V", "getDownloadLink", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AkiraboxRes {

        @NotNull
        private final String downloadLink;

        public static /* synthetic */ AkiraboxRes copy$default(AkiraboxRes akiraboxRes, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = akiraboxRes.downloadLink;
            }
            return akiraboxRes.copy(str);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDownloadLink() {
            return this.downloadLink;
        }

        @NotNull
        public final AkiraboxRes copy(@JsonProperty("download_link") @NotNull String downloadLink) {
            return new AkiraboxRes(downloadLink);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AkiraboxRes) && Intrinsics.areEqual(this.downloadLink, ((AkiraboxRes) other).downloadLink);
        }

        public int hashCode() {
            return this.downloadLink.hashCode();
        }

        @NotNull
        public String toString() {
            return "AkiraboxRes(downloadLink=" + this.downloadLink + ')';
        }

        public AkiraboxRes(@JsonProperty("download_link") @NotNull String downloadLink) {
            this.downloadLink = downloadLink;
        }

        @NotNull
        public final String getDownloadLink() {
            return this.downloadLink;
        }
    }
}
