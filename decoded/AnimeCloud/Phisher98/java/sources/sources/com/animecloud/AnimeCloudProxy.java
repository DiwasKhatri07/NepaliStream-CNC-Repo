package com.animecloud;

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
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AnimeCloud/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00120\u0016H\u0096@¢\u0006\u0002\u0010\u001aR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/animecloud/AnimeCloudProxy;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AnimeCloud"}, k = 1, mv = {2, 4, 0}, xi = 48)
public class AnimeCloudProxy extends ExtractorApi {

    @NotNull
    private String name = "AnimeCloudProxy";

    @NotNull
    private String mainUrl = "https://fireani.me";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.animecloud.AnimeCloudProxy$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.animecloud.AnimeCloudProxy", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {19, 20, 24}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "id", "$this", "url", "referer", "subtitleCallback", "callback", "id", "csrftkn", "$this", "url", "referer", "subtitleCallback", "callback", "id", "csrftkn", "seassion_ck", "m3u8", "headers"}, nl = {20, 21, 23}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
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
            return AnimeCloudProxy.getUrl$suspendImpl(AnimeCloudProxy.this, null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:21:0x01b5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:25:0x026e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x026f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object getUrl$suspendImpl(AnimeCloudProxy $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C00001 c00001;
        Object obj;
        int i;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Object obj2;
        String id;
        AnimeCloudProxy $this2;
        String id2;
        String csrftkn;
        AnimeCloudProxy $this3;
        Function1<? super ExtractorLink, Unit> function5;
        String id3;
        Object obj3;
        String referer3;
        String url2;
        String referer4;
        String url3;
        AnimeCloudProxy $this4;
        Function1<? super ExtractorLink, Unit> function6;
        Function1<? super ExtractorLink, Unit> function7;
        if (continuation instanceof C00001) {
            c00001 = (C00001) continuation;
            if ((c00001.label & Integer.MIN_VALUE) != 0) {
                c00001.label -= Integer.MIN_VALUE;
            } else {
                c00001 = $this.new C00001(continuation);
            }
        } else {
            c00001 = $this.new C00001(continuation);
        }
        C00001 c00002 = c00001;
        Object $result = c00002.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00002.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String id4 = StringsKt.substringAfterLast$default(url, "/", (String) null, 2, (Object) null);
                Requests app = MainActivityKt.getApp();
                String mainUrl = $this.getMainUrl();
                c00002.L$0 = $this;
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                c00002.L$4 = function2;
                c00002.L$5 = id4;
                c00002.label = 1;
                obj = coroutine_suspended;
                i = 2;
                Object obj4 = Requests.get$default(app, url, (Map) null, mainUrl, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4090, (Object) null);
                c00002 = c00002;
                if (obj4 == obj) {
                    return obj;
                }
                referer2 = referer;
                function3 = function1;
                function4 = function2;
                obj2 = obj4;
                id = id4;
                $this2 = $this;
                id2 = url;
                csrftkn = ((NiceResponse) obj2).getDocument().select("form#wrapper input[name=csrftkn]").attr("value");
                Requests app2 = MainActivityKt.getApp();
                String str = $this2.getMainUrl() + "/proxy/player/adehu1awmdxx?csrftkn=" + csrftkn;
                String mainUrl2 = $this2.getMainUrl();
                c00002.L$0 = $this2;
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(id2);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00002.L$4 = function4;
                c00002.L$5 = id;
                c00002.L$6 = SpillingKt.nullOutSpilledVariable(csrftkn);
                c00002.label = i;
                $this3 = $this2;
                C00001 c00003 = c00002;
                function5 = function4;
                id3 = id;
                obj3 = Requests.get$default(app2, str, (Map) null, mainUrl2, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00003, 4090, (Object) null);
                c00002 = c00003;
                if (obj3 == obj) {
                    return obj;
                }
                referer3 = csrftkn;
                url2 = id2;
                referer4 = referer2;
                url3 = id3;
                $this4 = $this3;
                function6 = function5;
                String seassion_ck = (String) ((NiceResponse) obj3).getCookies().get("session");
                String m3u8 = $this4.getMainUrl() + "/proxy/nocache/" + url3 + '/';
                Map headers = MapsKt.mapOf(TuplesKt.to("Cookie", "session=" + seassion_ck));
                String name = $this4.getName();
                String name2 = $this4.getName();
                ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                C00012 c00012 = $this4.new C00012(headers, null);
                c00002.L$0 = SpillingKt.nullOutSpilledVariable($this4);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(referer4);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00002.L$4 = SpillingKt.nullOutSpilledVariable(function6);
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(url3);
                c00002.L$6 = SpillingKt.nullOutSpilledVariable(referer3);
                c00002.L$7 = SpillingKt.nullOutSpilledVariable(seassion_ck);
                c00002.L$8 = SpillingKt.nullOutSpilledVariable(m3u8);
                c00002.L$9 = SpillingKt.nullOutSpilledVariable(headers);
                c00002.L$10 = function6;
                c00002.label = 3;
                $result = ExtractorApiKt.newExtractorLink(name, name2, m3u8, extractorLinkType, c00012, c00002);
                if ($result == obj) {
                    return obj;
                }
                function7 = function6;
                function7.invoke($result);
                return Unit.INSTANCE;
            case 1:
                String id5 = (String) c00002.L$5;
                Function1<? super ExtractorLink, Unit> function8 = (Function1) c00002.L$4;
                Function1<? super SubtitleFile, Unit> function9 = (Function1) c00002.L$3;
                String referer5 = (String) c00002.L$2;
                String url4 = (String) c00002.L$1;
                AnimeCloudProxy $this5 = (AnimeCloudProxy) c00002.L$0;
                ResultKt.throwOnFailure($result);
                $this2 = $this5;
                obj = coroutine_suspended;
                obj2 = $result;
                id = id5;
                function4 = function8;
                function3 = function9;
                referer2 = referer5;
                id2 = url4;
                i = 2;
                csrftkn = ((NiceResponse) obj2).getDocument().select("form#wrapper input[name=csrftkn]").attr("value");
                Requests app3 = MainActivityKt.getApp();
                String str2 = $this2.getMainUrl() + "/proxy/player/adehu1awmdxx?csrftkn=" + csrftkn;
                String mainUrl3 = $this2.getMainUrl();
                c00002.L$0 = $this2;
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(id2);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00002.L$4 = function4;
                c00002.L$5 = id;
                c00002.L$6 = SpillingKt.nullOutSpilledVariable(csrftkn);
                c00002.label = i;
                $this3 = $this2;
                C00001 c00004 = c00002;
                function5 = function4;
                id3 = id;
                obj3 = Requests.get$default(app3, str2, (Map) null, mainUrl3, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00004, 4090, (Object) null);
                c00002 = c00004;
                if (obj3 == obj) {
                    return obj;
                }
                referer3 = csrftkn;
                url2 = id2;
                referer4 = referer2;
                url3 = id3;
                $this4 = $this3;
                function6 = function5;
                String seassion_ck2 = (String) ((NiceResponse) obj3).getCookies().get("session");
                String m3u9 = $this4.getMainUrl() + "/proxy/nocache/" + url3 + '/';
                Map headers2 = MapsKt.mapOf(TuplesKt.to("Cookie", "session=" + seassion_ck2));
                String name3 = $this4.getName();
                String name4 = $this4.getName();
                ExtractorLinkType extractorLinkType2 = ExtractorLinkType.M3U8;
                C00012 c00013 = $this4.new C00012(headers2, null);
                c00002.L$0 = SpillingKt.nullOutSpilledVariable($this4);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(referer4);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00002.L$4 = SpillingKt.nullOutSpilledVariable(function6);
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(url3);
                c00002.L$6 = SpillingKt.nullOutSpilledVariable(referer3);
                c00002.L$7 = SpillingKt.nullOutSpilledVariable(seassion_ck2);
                c00002.L$8 = SpillingKt.nullOutSpilledVariable(m3u9);
                c00002.L$9 = SpillingKt.nullOutSpilledVariable(headers2);
                c00002.L$10 = function6;
                c00002.label = 3;
                $result = ExtractorApiKt.newExtractorLink(name3, name4, m3u9, extractorLinkType2, c00013, c00002);
                if ($result == obj) {
                    return obj;
                }
                function7 = function6;
                function7.invoke($result);
                return Unit.INSTANCE;
            case 2:
                String csrftkn2 = (String) c00002.L$6;
                String id6 = (String) c00002.L$5;
                Function1<? super ExtractorLink, Unit> function10 = (Function1) c00002.L$4;
                Function1<? super SubtitleFile, Unit> function11 = (Function1) c00002.L$3;
                String referer6 = (String) c00002.L$2;
                String url5 = (String) c00002.L$1;
                AnimeCloudProxy $this6 = (AnimeCloudProxy) c00002.L$0;
                ResultKt.throwOnFailure($result);
                $this4 = $this6;
                obj = coroutine_suspended;
                function3 = function11;
                referer4 = referer6;
                url2 = url5;
                obj3 = $result;
                referer3 = csrftkn2;
                url3 = id6;
                function6 = function10;
                String seassion_ck3 = (String) ((NiceResponse) obj3).getCookies().get("session");
                String m3u10 = $this4.getMainUrl() + "/proxy/nocache/" + url3 + '/';
                Map headers3 = MapsKt.mapOf(TuplesKt.to("Cookie", "session=" + seassion_ck3));
                String name5 = $this4.getName();
                String name6 = $this4.getName();
                ExtractorLinkType extractorLinkType3 = ExtractorLinkType.M3U8;
                C00012 c00014 = $this4.new C00012(headers3, null);
                c00002.L$0 = SpillingKt.nullOutSpilledVariable($this4);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(referer4);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00002.L$4 = SpillingKt.nullOutSpilledVariable(function6);
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(url3);
                c00002.L$6 = SpillingKt.nullOutSpilledVariable(referer3);
                c00002.L$7 = SpillingKt.nullOutSpilledVariable(seassion_ck3);
                c00002.L$8 = SpillingKt.nullOutSpilledVariable(m3u10);
                c00002.L$9 = SpillingKt.nullOutSpilledVariable(headers3);
                c00002.L$10 = function6;
                c00002.label = 3;
                $result = ExtractorApiKt.newExtractorLink(name5, name6, m3u10, extractorLinkType3, c00014, c00002);
                if ($result == obj) {
                    return obj;
                }
                function7 = function6;
                function7.invoke($result);
                return Unit.INSTANCE;
            case 3:
                function7 = (Function1) c00002.L$10;
                ResultKt.throwOnFailure($result);
                function7.invoke($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.animecloud.AnimeCloudProxy$getUrl$2 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.animecloud.AnimeCloudProxy$getUrl$2", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00012 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $headers;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00012(Map<String, String> map, Continuation<? super C00012> continuation) {
            super(2, continuation);
            this.$headers = map;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00012 = AnimeCloudProxy.this.new C00012(this.$headers, continuation);
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
                    $this$newExtractorLink.setReferer(AnimeCloudProxy.this.getMainUrl());
                    $this$newExtractorLink.setQuality(Qualities.P1080.getValue());
                    $this$newExtractorLink.setHeaders(this.$headers);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
