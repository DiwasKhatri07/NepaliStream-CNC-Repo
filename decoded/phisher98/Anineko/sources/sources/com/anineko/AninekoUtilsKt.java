package com.anineko;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AninekoUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Anineko/classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0004\u001a\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0003¨\u0006\b"}, d2 = {"getAnilistId", "", "title", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseAnimeData", "Lcom/anineko/MetaAnimeData;", "jsonString", "Anineko"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAninekoUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AninekoUtils.kt\ncom/anineko/AninekoUtilsKt\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,87:1\n73#2,5:88\n93#3,2:93\n63#3:95\n64#3,15:97\n95#3,2:114\n1#4:96\n50#5:112\n43#5:113\n*S KotlinDebug\n*F\n+ 1 AninekoUtils.kt\ncom/anineko/AninekoUtilsKt\n*L\n40#1:88,5\n50#1:93,2\n50#1:95\n50#1:97,15\n50#1:114,2\n50#1:96\n50#1:112\n50#1:113\n*E\n"})
public final class AninekoUtilsKt {

    /* JADX INFO: renamed from: com.anineko.AninekoUtilsKt$getAnilistId$1 */
    /* JADX INFO: compiled from: AninekoUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anineko.AninekoUtilsKt", f = "AninekoUtils.kt", i = {0, 0, 0, 0}, l = {36}, m = "getAnilistId", n = {"title", "query", "requestData", "headers"}, nl = {40}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class C00061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AninekoUtilsKt.getAnilistId(null, (Continuation) this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public static final Object getAnilistId(@NotNull String title, @NotNull Continuation<? super Integer> continuation) {
        C00061 c00061;
        Object safe;
        AniListData data;
        AniListMedia media;
        if (continuation instanceof C00061) {
            c00061 = (C00061) continuation;
            if ((c00061.label & Integer.MIN_VALUE) != 0) {
                c00061.label -= Integer.MIN_VALUE;
            } else {
                c00061 = new C00061(continuation);
            }
        } else {
            c00061 = new C00061(continuation);
        }
        Object $result = c00061.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00061.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    RequestBody requestData = RequestBody.Companion.create(AppUtils.INSTANCE.toJson(MapsKt.mapOf(new Pair[]{TuplesKt.to("query", "query($search: String) {\n    media: Media(search: $search, type: ANIME) {\n        id\n    }\n}"), TuplesKt.to("variables", MapsKt.mapOf(TuplesKt.to("search", title)))})), MediaType.Companion.parse("application/json;charset=utf-8"));
                    Map headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("Accept", "application/json"), TuplesKt.to("Content-Type", "application/json")});
                    try {
                        Requests app = MainActivityKt.getApp();
                        c00061.L$0 = SpillingKt.nullOutSpilledVariable(title);
                        c00061.L$1 = SpillingKt.nullOutSpilledVariable("query($search: String) {\n    media: Media(search: $search, type: ANIME) {\n        id\n    }\n}");
                        c00061.L$2 = SpillingKt.nullOutSpilledVariable(requestData);
                        c00061.L$3 = SpillingKt.nullOutSpilledVariable(headers);
                        c00061.label = 1;
                        try {
                            $result = Requests.post$default(app, "https://graphql.anilist.co", headers, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestData, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00061, 65276, (Object) null);
                            if ($result == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } catch (Exception e) {
                            return null;
                        }
                    } catch (Exception e2) {
                        return null;
                    }
                } catch (Exception e3) {
                    return null;
                }
                break;
            case 1:
                try {
                    ResultKt.throwOnFailure($result);
                } catch (Exception e4) {
                    return null;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            NiceResponse this_$iv = (NiceResponse) $result;
            try {
                ResponseParser parser = this_$iv.getParser();
                Intrinsics.checkNotNull(parser);
                safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(AniListSearchResponse.class));
            } catch (Exception e$iv) {
                e$iv.printStackTrace();
                safe = null;
            }
            AniListSearchResponse res = (AniListSearchResponse) safe;
            if (res == null || (data = res.getData()) == null || (media = data.getMedia()) == null) {
                return null;
            }
            return media.getId();
        } catch (Exception e5) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0066  */
    /* JADX WARN: Code duplicated, block: B:30:0x0082 A[Catch: Exception -> 0x0098, TRY_LEAVE, TryCatch #4 {Exception -> 0x0098, blocks: (B:12:0x0032, B:19:0x0060, B:22:0x0067, B:30:0x0082, B:29:0x007c, B:18:0x0055, B:11:0x0028, B:15:0x0039, B:8:0x000f, B:24:0x006d), top: B:44:0x000f, inners: #1, #3, #6 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Nullable
    public static final MetaAnimeData parseAnimeData(@NotNull String jsonString) {
        Object objDecodeFromString;
        Object obj;
        DeserializationStrategy deserializationStrategy;
        try {
            AppUtils appUtils = AppUtils.INSTANCE;
            if (jsonString == null) {
                objDecodeFromString = null;
            } else {
                try {
                    try {
                        Result.Companion companion = Result.Companion;
                        KType kTypeTypeOf = Reflection.typeOf(MetaAnimeData.class);
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    if (Result.exceptionOrNull-impl(obj) != null) {
                        try {
                            Result.Companion companion3 = Result.Companion;
                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(MetaAnimeData.class), (List) null, 2, (Object) null));
                        } catch (Throwable th2) {
                            Result.Companion companion4 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th2));
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        deserializationStrategy = (KSerializer) obj;
                        if (deserializationStrategy != null) {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, jsonString);
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv.readValue(jsonString, new TypeReference<MetaAnimeData>() { // from class: com.anineko.AninekoUtilsKt$parseAnimeData$$inlined$tryParseJson$1
                            });
                        }
                    } else {
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        deserializationStrategy = (KSerializer) obj;
                        if (deserializationStrategy != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, jsonString);
                            } catch (SerializationException e) {
                                ArchComponentExtKt.logError(e);
                                ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(jsonString, new TypeReference<MetaAnimeData>() { // from class: com.anineko.AninekoUtilsKt$parseAnimeData$$inlined$tryParseJson$1
                                });
                            } catch (Throwable th3) {
                                ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(jsonString, new TypeReference<MetaAnimeData>() { // from class: com.anineko.AninekoUtilsKt$parseAnimeData$$inlined$tryParseJson$1
                                });
                            }
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(jsonString, new TypeReference<MetaAnimeData>() { // from class: com.anineko.AninekoUtilsKt$parseAnimeData$$inlined$tryParseJson$1
                            });
                        }
                    }
                } catch (Exception e2) {
                    objDecodeFromString = null;
                }
            }
            return (MetaAnimeData) objDecodeFromString;
        } catch (Exception e3) {
            return null;
        }
    }
}
