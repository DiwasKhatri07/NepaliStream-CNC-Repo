package com.Animenosub;

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
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
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
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Animenosub/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00120\u0016H\u0096@¢\u0006\u0002\u0010\u001aR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/Animenosub/AnimenosubExtractor;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Animenosub"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class AnimenosubExtractor extends ExtractorApi {

    @NotNull
    private String name = "Animenosub";

    @NotNull
    private String mainUrl = "https://animenosub.upn.one";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.Animenosub.AnimenosubExtractor$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animenosub.AnimenosubExtractor", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {74, 80}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "headers", "hash", "url", "referer", "subtitleCallback", "callback", "headers", "hash", "encoded", "decryptedText", "m3u8"}, nl = {74, 79}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        Object L$0;
        Object L$1;
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

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnimenosubExtractor.this.getUrl(null, null, null, null, (Continuation) this);
        }
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

    /* JADX WARN: Code duplicated, block: B:27:0x017a  */
    /* JADX WARN: Code duplicated, block: B:31:0x0186  */
    /* JADX WARN: Code duplicated, block: B:33:0x018b  */
    /* JADX WARN: Code duplicated, block: B:35:0x01e0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:38:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        C00071 c00071;
        AnimenosubExtractor animenosubExtractor;
        String hash;
        Continuation continuation2;
        Object obj;
        int i;
        Object obj2;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Map headers;
        String encoded;
        String decryptedText;
        MatchResult matchResultFind$default;
        String m3u8;
        String m3u9;
        Object objNewExtractorLink;
        String m3u10;
        String url3;
        Function1<? super ExtractorLink, Unit> function5;
        Map headers2;
        String encoded2;
        String m3u11;
        String hash2;
        List groupValues;
        if (continuation instanceof C00071) {
            c00071 = (C00071) continuation;
            if ((c00071.label & Integer.MIN_VALUE) != 0) {
                c00071.label -= Integer.MIN_VALUE;
                animenosubExtractor = this;
            } else {
                animenosubExtractor = this;
                c00071 = animenosubExtractor.new C00071(continuation);
            }
        } else {
            animenosubExtractor = this;
            c00071 = animenosubExtractor.new C00071(continuation);
        }
        C00071 c00072 = c00071;
        Object $result = c00072.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00072.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Map headers3 = MapsKt.mapOf(TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:134.0) Gecko/20100101 Firefox/134.0"));
                String hash3 = StringsKt.substringAfterLast$default(url, "#", (String) null, 2, (Object) null);
                Requests app = MainActivityKt.getApp();
                String str = animenosubExtractor.getMainUrl() + "/api/v1/video?id=" + hash3;
                c00072.L$0 = url;
                c00072.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                c00072.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                c00072.L$3 = function2;
                c00072.L$4 = SpillingKt.nullOutSpilledVariable(headers3);
                c00072.L$5 = SpillingKt.nullOutSpilledVariable(hash3);
                c00072.label = 1;
                hash = hash3;
                continuation2 = null;
                obj = coroutine_suspended;
                i = 2;
                obj2 = Requests.get$default(app, str, headers3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00072, 4092, (Object) null);
                c00072 = c00072;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                referer2 = referer;
                function3 = function1;
                function4 = function2;
                headers = headers3;
                encoded = StringsKt.trim(((NiceResponse) obj2).getText()).toString();
                decryptedText = AesHelper.INSTANCE.decryptAES(encoded, "kiemtienmua911ca", "0123456789abcdef");
                matchResultFind$default = Regex.find$default(new Regex("\"source\":\"(.*?)\""), decryptedText, 0, i, continuation2);
                if (matchResultFind$default == null && (groupValues = matchResultFind$default.getGroupValues()) != null) {
                    String str2 = (String) groupValues.get(1);
                    if (str2 == null || (m3u8 = StringsKt.replace$default(str2, "\\/", "/", false, 4, (Object) null)) == null) {
                    }
                    if (m3u8.length() > 0) {
                        m3u9 = m3u8;
                        String m3u12 = animenosubExtractor.getName();
                        String name = animenosubExtractor.getName();
                        ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                        C00082 c00082 = new C00082(url2, continuation2);
                        c00072.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        c00072.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                        c00072.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                        c00072.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                        c00072.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                        c00072.L$5 = SpillingKt.nullOutSpilledVariable(hash);
                        c00072.L$6 = SpillingKt.nullOutSpilledVariable(encoded);
                        c00072.L$7 = SpillingKt.nullOutSpilledVariable(decryptedText);
                        c00072.L$8 = SpillingKt.nullOutSpilledVariable(m3u9);
                        c00072.L$9 = function4;
                        c00072.label = i;
                        objNewExtractorLink = ExtractorApiKt.newExtractorLink(m3u12, name, m3u9, extractorLinkType, c00082, c00072);
                        if (objNewExtractorLink == obj) {
                            return obj;
                        }
                        m3u10 = m3u9;
                        url3 = url2;
                        function5 = function4;
                        headers2 = headers;
                        encoded2 = encoded;
                        m3u11 = decryptedText;
                        hash2 = hash;
                        function5.invoke(objNewExtractorLink);
                    }
                    return Unit.INSTANCE;
                }
                if (m3u8.length() > 0) {
                    m3u9 = m3u8;
                    String m3u13 = animenosubExtractor.getName();
                    String name2 = animenosubExtractor.getName();
                    ExtractorLinkType extractorLinkType2 = ExtractorLinkType.M3U8;
                    C00082 c00083 = new C00082(url2, continuation2);
                    c00072.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00072.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00072.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00072.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                    c00072.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                    c00072.L$5 = SpillingKt.nullOutSpilledVariable(hash);
                    c00072.L$6 = SpillingKt.nullOutSpilledVariable(encoded);
                    c00072.L$7 = SpillingKt.nullOutSpilledVariable(decryptedText);
                    c00072.L$8 = SpillingKt.nullOutSpilledVariable(m3u9);
                    c00072.L$9 = function4;
                    c00072.label = i;
                    objNewExtractorLink = ExtractorApiKt.newExtractorLink(m3u13, name2, m3u9, extractorLinkType2, c00083, c00072);
                    if (objNewExtractorLink == obj) {
                        return obj;
                    }
                    m3u10 = m3u9;
                    url3 = url2;
                    function5 = function4;
                    headers2 = headers;
                    encoded2 = encoded;
                    m3u11 = decryptedText;
                    hash2 = hash;
                    function5.invoke(objNewExtractorLink);
                }
                return Unit.INSTANCE;
            case 1:
                String hash4 = (String) c00072.L$5;
                Map headers4 = (Map) c00072.L$4;
                function4 = (Function1) c00072.L$3;
                function3 = (Function1) c00072.L$2;
                referer2 = (String) c00072.L$1;
                String url4 = (String) c00072.L$0;
                ResultKt.throwOnFailure($result);
                hash = hash4;
                headers = headers4;
                i = 2;
                url2 = url4;
                obj = coroutine_suspended;
                continuation2 = null;
                obj2 = $result;
                encoded = StringsKt.trim(((NiceResponse) obj2).getText()).toString();
                decryptedText = AesHelper.INSTANCE.decryptAES(encoded, "kiemtienmua911ca", "0123456789abcdef");
                matchResultFind$default = Regex.find$default(new Regex("\"source\":\"(.*?)\""), decryptedText, 0, i, continuation2);
                m3u8 = matchResultFind$default == null ? "" : "";
                if (m3u8.length() > 0) {
                    m3u9 = m3u8;
                    String m3u14 = animenosubExtractor.getName();
                    String name3 = animenosubExtractor.getName();
                    ExtractorLinkType extractorLinkType3 = ExtractorLinkType.M3U8;
                    C00082 c00084 = new C00082(url2, continuation2);
                    c00072.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00072.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                    c00072.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                    c00072.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                    c00072.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                    c00072.L$5 = SpillingKt.nullOutSpilledVariable(hash);
                    c00072.L$6 = SpillingKt.nullOutSpilledVariable(encoded);
                    c00072.L$7 = SpillingKt.nullOutSpilledVariable(decryptedText);
                    c00072.L$8 = SpillingKt.nullOutSpilledVariable(m3u9);
                    c00072.L$9 = function4;
                    c00072.label = i;
                    objNewExtractorLink = ExtractorApiKt.newExtractorLink(m3u14, name3, m3u9, extractorLinkType3, c00084, c00072);
                    if (objNewExtractorLink == obj) {
                        return obj;
                    }
                    m3u10 = m3u9;
                    url3 = url2;
                    function5 = function4;
                    headers2 = headers;
                    encoded2 = encoded;
                    m3u11 = decryptedText;
                    hash2 = hash;
                    function5.invoke(objNewExtractorLink);
                }
                return Unit.INSTANCE;
            case 2:
                function5 = (Function1) c00072.L$9;
                m3u10 = (String) c00072.L$8;
                m3u11 = (String) c00072.L$7;
                encoded2 = (String) c00072.L$6;
                hash2 = (String) c00072.L$5;
                headers2 = (Map) c00072.L$4;
                url3 = (String) c00072.L$0;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink = $result;
                function5.invoke(objNewExtractorLink);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.Animenosub.AnimenosubExtractor$getUrl$2 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Animenosub.AnimenosubExtractor$getUrl$2", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00082 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $url;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00082(String str, Continuation<? super C00082> continuation) {
            super(2, continuation);
            this.$url = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00082 = new C00082(this.$url, continuation);
            c00082.L$0 = obj;
            return c00082;
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
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
