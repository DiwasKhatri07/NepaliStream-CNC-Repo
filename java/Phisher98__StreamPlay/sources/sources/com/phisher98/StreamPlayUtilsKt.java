package com.phisher98;

import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Base64;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.M3u8Helper;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KType;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000¥\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b$*\u0001\u0016\u001a\b\u0010\u0018\u001a\u00020\u0019H\u0002\u001a\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010\u001d\u001a4\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001b2\b\u0010!\u001a\u0004\u0018\u00010\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u001b2\u0006\u0010#\u001a\u00020$H\u0086@¢\u0006\u0002\u0010%\u001a4\u0010&\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001b2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010\u001b2\u0006\u0010#\u001a\u00020$H\u0086@¢\u0006\u0002\u0010*\u001a\u0016\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u001b\u001ah\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001b2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020/032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020/032\n\b\u0002\u00107\u001a\u0004\u0018\u00010(2\b\b\u0002\u00108\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u00109\u001aj\u0010:\u001a\u00020/2\b\u0010;\u001a\u0004\u0018\u00010\u001b2\b\u0010<\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001b2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020/032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020/032\n\b\u0002\u00107\u001a\u0004\u0018\u00010(H\u0086@¢\u0006\u0002\u0010=\u001a\u0017\u0010>\u001a\u0004\u0018\u00010\u001b2\b\u0010?\u001a\u0004\u0018\u00010(¢\u0006\u0002\u0010@\u001a/\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0B2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010(¢\u0006\u0002\u0010D\u001a\u000e\u0010E\u001a\u0004\u0018\u00010\u001b*\u0004\u0018\u00010\u001b\u001a\u0012\u0010F\u001a\u0004\u0018\u00010\u001b2\b\u0010G\u001a\u0004\u0018\u00010\u001b\u001a\u001a\u0010H\u001a\u00020\u001b2\b\u0010G\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010I\u001a\u00020J\u001a\u0010\u0010K\u001a\u00020(2\b\u0010G\u001a\u0004\u0018\u00010\u001b\u001a\u001c\u0010L\u001a\b\u0012\u0004\u0012\u00020\u001b0M2\u0006\u0010\u001c\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010\u001d\u001a\u000e\u0010N\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b\u001a\n\u0010O\u001a\u00020\u001b*\u00020\u001b\u001a\u0010\u0010P\u001a\u00020J2\b\u0010Q\u001a\u0004\u0018\u00010\u001b\u001a\u0006\u0010R\u001a\u00020S\u001a\u0016\u0010T\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010U\u001a\u00020\u001b\u001a\n\u0010V\u001a\u00020\u001b*\u00020(\u001a^\u0010W\u001a\u00020/2\n\b\u0002\u0010X\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010(2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020/032\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u001bH\u0086@¢\u0006\u0002\u0010Z\u001a\u0014\u0010[\u001a\b\u0012\u0004\u0012\u00020\\0M2\u0006\u0010]\u001a\u00020\u001b\u001a:\u0010^\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0018\u00010_2\u0006\u0010`\u001a\u00020\u001b2\u0006\u0010a\u001a\u00020\u001b2\u0006\u0010b\u001a\u00020\u001b2\u0006\u0010c\u001a\u00020d\u001a\u0010\u0010e\u001a\u00020\u001b2\u0006\u0010f\u001a\u00020\u001bH\u0002\u001a\n\u0010g\u001a\u00020d*\u00020\u001b\u001a\u000e\u0010m\u001a\u00020\u001b2\u0006\u0010n\u001a\u00020\u001b\u001a\u001f\u0010o\u001a\u0004\u0018\u00010(2\u0006\u0010p\u001a\u00020\u001b2\b\u0010q\u001a\u0004\u0018\u00010(¢\u0006\u0002\u0010r\u001a\u0010\u0010u\u001a\u0004\u0018\u00010v2\u0006\u0010p\u001a\u00020\u001b\u001a\u000e\u0010w\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001b\u001a\n\u0010x\u001a\u00020\u001b*\u00020\u001b\u001a\u000e\u0010y\u001a\u00020\u001b2\u0006\u0010z\u001a\u00020\u001b\u001a,\u0010{\u001a\b\u0012\u0004\u0012\u0002060M2\u0006\u0010|\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u001b2\u0006\u0010}\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010~\u001a\u0018\u0010\u007f\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010\u001d\u001a\u0010\u0010\u0080\u0001\u001a\u00020\u001b2\u0007\u0010\u0081\u0001\u001a\u00020\u001b\u001a\u000f\u0010\u0082\u0001\u001a\u00020\u001b2\u0006\u0010f\u001a\u00020\u001b\u001a\u0012\u0010\u0083\u0001\u001a\u00020\u001b2\u0007\u0010\u0084\u0001\u001a\u00020dH\u0002\u001a\u0012\u0010\u0085\u0001\u001a\u00020\u001b2\u0007\u0010\u0084\u0001\u001a\u00020\u001bH\u0002\u001a\u001b\u0010\u0086\u0001\u001a\u00020\u001b2\f\b\u0002\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001¢\u0006\u0003\u0010\u0089\u0001\u001a^\u0010\u008a\u0001\u001a\u00020\u001b2\u0007\u0010\u008b\u0001\u001a\u00020\u001b2\u000b\b\u0002\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u001b2\u000b\b\u0002\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u000b\b\u0002\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u001b2\t\b\u0002\u0010\u008f\u0001\u001a\u00020J2\f\b\u0002\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001¢\u0006\u0003\u0010\u0090\u0001\u001aE\u0010\u0091\u0001\u001a\u00020\u001b2\u0007\u0010\u008b\u0001\u001a\u00020\u001b2\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u001b2\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0092\u0001\u001a\u00030\u0088\u0001H\u0002\u001a:\u0010\u0093\u0001\u001a\u00020\u001b2\u000b\b\u0002\u0010\u0094\u0001\u001a\u0004\u0018\u00010(2\u0006\u0010#\u001a\u00020\u001b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010(¢\u0006\u0003\u0010\u0095\u0001\u001a\u0010\u0010\u0096\u0001\u001a\u00020d2\u0007\u0010\u0097\u0001\u001a\u00020\u001b\u001a\u0011\u0010\u0098\u0001\u001a\u00030\u0099\u00012\u0007\u0010\u009a\u0001\u001a\u00020d\u001ab\u0010\u009b\u0001\u001a\u00030\u009c\u00012\t\b\u0002\u0010\u009d\u0001\u001a\u00020(2D\u0010\u009e\u0001\u001a#\u0012\u001e\b\u0001\u0012\u001a\b\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020/0 \u0001\u0012\u0007\u0012\u0005\u0018\u00010\u009c\u0001030\u009f\u0001\"\u001a\b\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020/0 \u0001\u0012\u0007\u0012\u0005\u0018\u00010\u009c\u000103H\u0086@¢\u0006\u0003\u0010¡\u0001\u001a\u0018\u0010¢\u0001\u001a\u00020\u001b2\u0007\u0010£\u0001\u001a\u00020\u001b2\u0006\u0010c\u001a\u00020d\u001a\u001a\u0010¤\u0001\u001a\u00020\u001b2\t\u0010¥\u0001\u001a\u0004\u0018\u00010\u001bH\u0086@¢\u0006\u0002\u0010\u001d\u001a\u0018\u0010¨\u0001\u001a\u00020\u001b2\u0007\u0010¥\u0001\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010\u001d\u001a\u0010\u0010©\u0001\u001a\u00020\u001b2\u0007\u0010ª\u0001\u001a\u00020\u001b\u001a\u000b\u0010«\u0001\u001a\u00020\u001b*\u00020\u001b\u001a\u0007\u0010¬\u0001\u001a\u00020\u001b\u001aB\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u001b2\u0007\u0010®\u0001\u001a\u00020\u001b2\u0007\u0010¯\u0001\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2\t\u0010°\u0001\u001a\u0004\u0018\u00010(2\t\u0010±\u0001\u001a\u0004\u0018\u00010\u001bH\u0086@¢\u0006\u0003\u0010²\u0001\u001a\u000f\u0010³\u0001\u001a\u0004\u0018\u00010\u001b*\u0004\u0018\u00010\u001b\u001aH\u0010´\u0001\u001a\u00020/2\u0006\u00100\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020/032\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020/03H\u0086@¢\u0006\u0003\u0010µ\u0001\u001a\"\u0010¶\u0001\u001a\u00020\u001b2\u0019\u0010·\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0M0i\u001a\"\u0010¾\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0M0i2\u0007\u0010¿\u0001\u001a\u00020\u001b\u001a\u0007\u0010Ä\u0001\u001a\u00020\u001b\u001a\u0019\u0010Å\u0001\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010\u001d\u001ap\u0010Æ\u0001\u001a\u00030Ç\u00012\u0006\u0010\u001c\u001a\u00020\u001b2\u0017\b\u0002\u0010È\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0018\u00010i2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001b2\f\b\u0002\u0010É\u0001\u001a\u0005\u0018\u00010\u0088\u00012\f\b\u0002\u0010Ê\u0001\u001a\u0005\u0018\u00010Ë\u00012\t\b\u0002\u0010Ì\u0001\u001a\u00020J2\t\b\u0002\u0010Í\u0001\u001a\u00020(H\u0086@¢\u0006\u0003\u0010Î\u0001\u001a!\u0010Ï\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0B0M2\u0006\u0010`\u001a\u00020\u001b\u001a\u001b\u0010Ð\u0001\u001a\u0004\u0018\u00010\u001b2\u0007\u0010Ñ\u0001\u001a\u00020\u001b2\u0007\u0010Ò\u0001\u001a\u00020(\u001aq\u0010Ó\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0005\u0012\u0003HÕ\u00010M0Ô\u0001\"\u0005\b\u0000\u0010Ö\u0001\"\u0005\b\u0001\u0010Õ\u0001*\n\u0012\u0005\u0012\u0003HÖ\u00010×\u00012\t\b\u0002\u0010\u009d\u0001\u001a\u00020(2,\b\u0004\u0010Ø\u0001\u001a%\b\u0001\u0012\u0005\u0012\u0003HÖ\u0001\u0012\u000e\u0012\f\u0012\u0007\u0012\u0005\u0018\u0001HÕ\u00010 \u0001\u0012\u0007\u0012\u0005\u0018\u00010\u009c\u00010Ù\u0001H\u0086H¢\u0006\u0003\u0010Ú\u0001\u001a\u0010\u0010Û\u0001\u001a\u00020\u001b2\u0007\u0010\u0084\u0001\u001a\u00020\u001b\u001a+\u0010Ü\u0001\u001a\u00020\u001b2\u0007\u0010Ý\u0001\u001a\u00020\u001b2\u0006\u0010U\u001a\u00020\u001b2\b\u0010Þ\u0001\u001a\u00030ß\u0001H\u0086@¢\u0006\u0003\u0010à\u0001\u001a\u0013\u0010á\u0001\u001a\u00030â\u00012\t\u0010ã\u0001\u001a\u0004\u0018\u00010\u001b\u001ac\u0010ä\u0001\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001b0_0M2\u0007\u0010å\u0001\u001a\u00020\u001b2\n\u0010æ\u0001\u001a\u0005\u0018\u00010â\u00012\u0007\u0010ç\u0001\u001a\u00020(2\u0006\u0010 \u001a\u00020\u001b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010(¢\u0006\u0003\u0010è\u0001\u001a6\u0010é\u0001\u001a\u00020\u001b2\u0007\u0010å\u0001\u001a\u00020\u001b2\u0007\u0010ê\u0001\u001a\u00020\u001b2\u0007\u0010ë\u0001\u001a\u00020\u001b2\t\u0010ì\u0001\u001a\u0004\u0018\u00010\u001b2\u0007\u0010í\u0001\u001a\u00020\u001b\u001a\u000f\u0010î\u0001\u001a\u00020(2\u0006\u0010\u001c\u001a\u00020\u001b\u001a\u0010\u0010ï\u0001\u001a\u00020\u001b2\u0007\u0010\u0084\u0001\u001a\u00020\u001b\u001aU\u0010ð\u0001\u001a\u0005\u0018\u0001Hñ\u0001\"\u0005\b\u0000\u0010ñ\u00012\t\b\u0002\u0010ò\u0001\u001a\u00020(2\n\b\u0002\u0010ó\u0001\u001a\u00030\u0088\u00012\"\u0010ô\u0001\u001a\u001d\b\u0001\u0012\u000e\u0012\f\u0012\u0007\u0012\u0005\u0018\u0001Hñ\u00010 \u0001\u0012\u0007\u0012\u0005\u0018\u00010\u009c\u000103H\u0086@¢\u0006\u0003\u0010õ\u0001\u001a\u0012\u0010ö\u0001\u001a\u0004\u0018\u00010\u001b2\u0007\u0010÷\u0001\u001a\u00020\u001b\u001a\u0010\u0010ø\u0001\u001a\u00020d2\u0007\u0010ù\u0001\u001a\u00020\u001b\u001a\u0012\u0010ú\u0001\u001a\u0004\u0018\u00010\u001b2\u0007\u0010\u0081\u0001\u001a\u00020\u001b\u001a\u0012\u0010û\u0001\u001a\u0004\u0018\u00010\u001b2\u0007\u0010ü\u0001\u001a\u00020\u001b\u001a\u0007\u0010ý\u0001\u001a\u00020\u001b\u001a\"\u0010þ\u0001\u001a\u00020d2\u0007\u0010ÿ\u0001\u001a\u00020\u001b2\u0007\u0010\u0080\u0002\u001a\u00020d2\u0007\u0010\u0081\u0002\u001a\u00020d\u001a\u0018\u0010\u0082\u0002\u001a\u00020\u001b2\u0007\u0010\u0083\u0002\u001a\u00020\u001b2\u0006\u0010c\u001a\u00020d\u001a\u001a\u0010\u0084\u0002\u001a\u0004\u0018\u00010\u001b2\u0007\u0010\u0085\u0002\u001a\u00020\u001b2\u0006\u0010c\u001a\u00020d\"\u0013\u0010\u0000\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\"\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\"\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013\"\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017\"#\u0010h\u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0j0i¢\u0006\b\n\u0000\u001a\u0004\bk\u0010l\")\u0010s\u001a\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b030i¢\u0006\b\n\u0000\u001a\u0004\bt\u0010l\"\u0010\u0010¦\u0001\u001a\u00030§\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0015\u0010¸\u0001\u001a\b\u0012\u0004\u0012\u00020\u001b0MX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010¹\u0001\u001a\u00030º\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"1\u0010»\u0001\u001a \u0012\u0004\u0012\u00020\u001b\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0i0M0i¢\u0006\t\n\u0000\u001a\u0005\b¼\u0001\u0010l\".\u0010½\u0001\u001a!\u0012\u0004\u0012\u00020\u001b\u0012\u0017\u0012\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u001b\u0012\u0005\u0012\u00030º\u00010B0M0iX\u0082\u0004¢\u0006\u0002\n\u0000\"\u001f\u0010À\u0001\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÃ\u0001\u0010\u000f\u001a\u0006\bÁ\u0001\u0010Â\u0001¨\u0006\u0086\u0002"}, d2 = {"sharedPref", "Landroid/content/SharedPreferences;", "getSharedPref", "()Landroid/content/SharedPreferences;", "appGlobalSemaphore", "Lkotlinx/coroutines/sync/Semaphore;", "getAppGlobalSemaphore", "()Lkotlinx/coroutines/sync/Semaphore;", "extractorCallbackScope", "Lkotlinx/coroutines/CoroutineScope;", "sharedObjectMapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "getSharedObjectMapper", "()Lcom/fasterxml/jackson/databind/ObjectMapper;", "sharedObjectMapper$delegate", "Lkotlin/Lazy;", "sharedGson", "Lcom/google/gson/Gson;", "getSharedGson", "()Lcom/google/gson/Gson;", "sharedGson$delegate", "tmdbDateFormatter", "com/phisher98/StreamPlayUtilsKt$tmdbDateFormatter$1", "Lcom/phisher98/StreamPlayUtilsKt$tmdbDateFormatter$1;", "getTmdbDateFormatter", "Ljava/text/SimpleDateFormat;", "bypassHrefli", "", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "convertTmdbToAnimeId", "Lcom/phisher98/AniIds;", "title", "date", "airedDate", "type", "Lcom/lagradost/cloudstream3/TvType;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tmdbToAnimeId", "year", "", "season", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateWpKey", "r", "m", "loadSourceNameExtractor", "", "source", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "quality", "size", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadDisplaySourceNameExtractor", "sourceName", "displayName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSeason", "month", "(Ljava/lang/Integer;)Ljava/lang/String;", "getEpisodeSlug", "Lkotlin/Pair;", "episode", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lkotlin/Pair;", "createSlug", "getKisskhTitle", "str", "getIndexQualityTags", "fullTag", "", "getIndexQuality", "extractMdrive", "", "getBaseUrl", "getHost", "isUpcoming", "dateString", "getDate", "Lcom/phisher98/TmdbDate;", "fixUrl", "domain", "toRomanNumeral", "invokeExternalSource", "mediaId", "token", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseJsonToEpisodes", "Lcom/phisher98/EpisoderesponseKAA;", "json", "getSignature", "Lkotlin/Triple;", "html", "server", "query", "key", "", "sha1sum", "value", "decodeHex", "languageMap", "", "", "getLanguageMap", "()Ljava/util/Map;", "getLanguage", "code", "getAnidbEid", "jsonString", "episodeNumber", "(Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;", "decryptMethods", "getDecryptMethods", "parseAnimeData", "Lcom/phisher98/MetaAnimeData;", "cleanTitle", "fixUrlPath", "decrypthex", "inputStr", "getM3u8Qualities", "m3u8Link", "qualityName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRedirectLinks", "hdhubencode", "encoded", "hdhubpen", "md5", "input", "reverseString", "generateXClientToken", "hardcodedTimestamp", "", "(Ljava/lang/Long;)Ljava/lang/String;", "generateXTrSignature", "method", "accept", "contentType", "body", "useAltKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Long;)Ljava/lang/String;", "buildCanonicalString", "timestamp", "vidrockEncode", "tmdb", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/String;", "fromHex", "hex", "importKey", "Ljavax/crypto/spec/SecretKeySpec;", "rawKey", "runLimitedAsync", "", "concurrency", "tasks", "", "Lkotlin/coroutines/Continuation;", "(I[Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "decryptVidzeeUrl", "encrypted", "yflixDecode", "text", "JSON", "Lokhttp3/MediaType;", "yflixDecodeReverse", "yflixextractVideoUrlFromJson", "jsonData", "fixSourceUrl", "generateHexKey32", "fetchTmdbLogoUrl", "tmdbAPI", "apiKey", "tmdbId", "appLangCode", "(Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fixTitle", "getHindMoviezLinks", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildExtractedTitle", "extracted", "ORDERED_SPEC_CATEGORIES", "FILE_SIZE_REGEX", "Lkotlin/text/Regex;", "SPEC_OPTIONS", "getSPEC_OPTIONS", "SPEC_REGEX_CACHE", "extractSpecs", "inputString", "BROWSER_FINGERPRINT", "getBROWSER_FINGERPRINT", "()Ljava/lang/String;", "BROWSER_FINGERPRINT$delegate", "generateBrowserFingerprint", "bypassXD", "safeGet", "Lcom/lagradost/nicehttp/NiceResponse;", "headers", "timeout", "interceptor", "Lokhttp3/Interceptor;", "allowRedirects", "cacheTime", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Long;Lokhttp3/Interceptor;ZILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractXpassBackups", "solvePowChallenge", "challenge", "difficulty", "safeAmap", "Lkotlin/Result;", "B", "A", "", "f", "Lkotlin/Function2;", "(Ljava/lang/Iterable;ILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hindmoviezbase64Url", "hindmoviezsignHShare", "rawId", "pageDoc", "Lorg/jsoup/nodes/Document;", "(Ljava/lang/String;Ljava/lang/String;Lorg/jsoup/nodes/Document;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cinemacityparseSubtitles", "Lorg/json/JSONArray;", "raw", "cinemacitybuildDownloadLinks", "base", "subtitles", "selectedAudioIndex", "(Ljava/lang/String;Lorg/json/JSONArray;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/util/List;", "cinemacitymakeDownloadHref", "videoPath", "audioPath", "subtitlePaths", "name", "cinemacityextractQuality", "moviesdrivebase64Decode", "retry", "T", "times", "delayMs", "block", "(IJLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "peachifyDecrypt", "encrypt", "b64UrlDecode", "data", "decodeToBeParsed", "decryptVidrockUrl", "encryptedPayload", "goatedGenerateRandomIP", "goatedDeriveKey", "tokenString", "salt", "info", "goatedEncryptParams", "payloadStr", "goatedDecryptUrl", "b64Url", "StreamPlay"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 7 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 8 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 9 Uri.kt\nandroidx/core/net/UriKt\n+ 10 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 11 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 12 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 13 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,2265:1\n651#2,7:2266\n610#2:2509\n559#2:2510\n73#3,5:2273\n73#3,5:2301\n73#3,5:2306\n73#3,5:2311\n37#4,2:2278\n1#5:2280\n1#5:2298\n1#5:2361\n1#5:2375\n1#5:2381\n1#5:2438\n437#6:2281\n513#6,5:2282\n990#6:2331\n1065#6,3:2332\n990#6:2444\n1065#6,3:2445\n1000#6:2452\n1033#6,4:2453\n459#6:2457\n471#6:2458\n1207#6,2:2459\n472#6,2:2461\n1209#6:2463\n474#6:2464\n990#6:2465\n1065#6,3:2466\n990#6:2469\n1065#6,3:2470\n990#6:2473\n1065#6,3:2474\n990#6:2481\n1065#6,3:2482\n1000#6:2489\n1033#6,4:2490\n990#6:2494\n1065#6,3:2495\n990#6:2498\n1065#6,3:2499\n1000#6:2502\n1033#6,4:2503\n1795#7,10:2287\n2068#7:2297\n2069#7:2299\n1805#7:2300\n777#7:2316\n873#7,2:2317\n2068#7,2:2319\n1739#7:2321\n1814#7,3:2322\n296#7,2:2325\n1544#7:2336\n1633#7,5:2337\n1795#7,10:2350\n2068#7:2360\n2069#7:2362\n1805#7:2363\n1795#7,10:2364\n2068#7:2374\n2069#7:2376\n1805#7:2377\n2068#7,2:2401\n1739#7:2403\n1814#7,3:2404\n777#7:2407\n873#7,2:2408\n777#7:2410\n873#7,2:2411\n1739#7:2413\n1814#7,3:2414\n1739#7:2417\n1814#7,3:2418\n1358#7,2:2421\n1435#7,4:2423\n1795#7,10:2427\n2068#7:2437\n2069#7:2439\n1805#7:2440\n777#7:2441\n873#7,2:2442\n1739#7:2448\n1814#7,3:2449\n1739#7:2477\n1814#7,3:2478\n1739#7:2485\n1814#7,3:2486\n2068#7,2:2507\n1419#7,2:2511\n1739#7:2513\n1814#7,3:2514\n1422#7:2517\n1505#8,2:2327\n1505#8,2:2329\n29#9:2335\n221#10,2:2342\n81#11,6:2344\n93#12,2:2378\n63#12:2380\n64#12,15:2382\n95#12,2:2399\n50#13:2397\n43#13:2398\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt\n*L\n184#1:2266,7\n1589#1:2509\n1589#1:2510\n190#1:2273,5\n571#1:2301,5\n574#1:2306,5\n589#1:2311,5\n196#1:2278,2\n331#1:2298\n1838#1:2361\n1915#1:2375\n1926#1:2381\n1985#1:2438\n302#1:2281\n302#1:2282,5\n1115#1:2331\n1115#1:2332,3\n878#1:2444\n878#1:2445,3\n885#1:2452\n885#1:2453,4\n889#1:2457\n889#1:2458\n889#1:2459,2\n889#1:2461,2\n889#1:2463\n889#1:2464\n894#1:2465\n894#1:2466,3\n906#1:2469\n906#1:2470,3\n910#1:2473\n910#1:2474,3\n916#1:2481\n916#1:2482,3\n923#1:2489\n923#1:2490,4\n925#1:2494\n925#1:2495,3\n931#1:2498\n931#1:2499,3\n942#1:2502\n942#1:2503,4\n331#1:2287,10\n331#1:2297\n331#1:2299\n331#1:2300\n589#1:2316\n589#1:2317,2\n707#1:2319,2\n739#1:2321\n739#1:2322,3\n854#1:2325,2\n1515#1:2336\n1515#1:2337,5\n1838#1:2350,10\n1838#1:2360\n1838#1:2362\n1838#1:2363\n1915#1:2364,10\n1915#1:2374\n1915#1:2376\n1915#1:2377\n1939#1:2401,2\n1962#1:2403\n1962#1:2404,3\n1964#1:2407\n1964#1:2408,2\n1965#1:2410\n1965#1:2411,2\n2124#1:2413\n2124#1:2414,3\n2194#1:2417\n2194#1:2418,3\n98#1:2421,2\n98#1:2423,4\n1985#1:2427,10\n1985#1:2437\n1985#1:2439\n1985#1:2440\n1990#1:2441\n1990#1:2442,2\n883#1:2448\n883#1:2449,3\n911#1:2477\n911#1:2478,3\n921#1:2485\n921#1:2486,3\n959#1:2507,2\n1589#1:2511,2\n1590#1:2513\n1590#1:2514,3\n1589#1:2517\n1029#1:2327,2\n1086#1:2329,2\n1181#1:2335\n1600#1:2342,2\n1822#1:2344,6\n1926#1:2378,2\n1926#1:2380\n1926#1:2382,15\n1926#1:2399,2\n1926#1:2397\n1926#1:2398\n*E\n"})
public final class StreamPlayUtilsKt {

    @NotNull
    private static final Lazy BROWSER_FINGERPRINT$delegate;

    @NotNull
    private static final Regex FILE_SIZE_REGEX;

    @NotNull
    private static final MediaType JSON;

    @NotNull
    private static final List<String> ORDERED_SPEC_CATEGORIES;

    @NotNull
    private static final Map<String, List<Map<String, String>>> SPEC_OPTIONS;

    @NotNull
    private static final Map<String, List<Pair<String, Regex>>> SPEC_REGEX_CACHE;

    @NotNull
    private static final Semaphore appGlobalSemaphore;

    @NotNull
    private static final Map<String, Function1<String, String>> decryptMethods;

    @NotNull
    private static final CoroutineScope extractorCallbackScope;

    @NotNull
    private static final Map<String, Set<String>> languageMap;

    @NotNull
    private static final Lazy sharedGson$delegate;

    @NotNull
    private static final Lazy sharedObjectMapper$delegate;

    @Nullable
    private static final SharedPreferences sharedPref = null;

    @NotNull
    private static final StreamPlayUtilsKt$tmdbDateFormatter$1 tmdbDateFormatter;

    /* JADX INFO: renamed from: com.phisher98.StreamPlayUtilsKt$bypassHrefli$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayUtilsKt", f = "StreamPlayUtils.kt", i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4}, l = {102, 106, 110, 113, 118}, m = "bypassHrefli", n = {"url", "host", "url", "host", "res", "formUrl", "formData", "url", "host", "res", "formUrl", "formData", "url", "host", "res", "formUrl", "formData", "skToken", "url", "host", "res", "formUrl", "formData", "skToken", "driveUrl"}, nl = {103, 107, 111, 117, 119}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
    static final class C02701 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C02701(Continuation<? super C02701> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayUtilsKt.bypassHrefli(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayUtilsKt$bypassXD$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayUtilsKt", f = "StreamPlayUtils.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}, l = {1645, 1674, 1693, 1770, 1786, 1801, 1807}, m = "bypassXD", n = {"url", "url", "redirect", "baseUrl", "code", "fingerprint", "mouseData", "baseHeaders", "url", "redirect", "baseUrl", "code", "fingerprint", "mouseData", "baseHeaders", "sessionJson", "sessionId", "cookieHeaders", "url", "redirect", "baseUrl", "code", "fingerprint", "mouseData", "baseHeaders", "sessionJson", "sessionId", "cookieHeaders", "rebindJson", "rebindToken", "wsBaseUrl", "visibleTimeDone", "okHttpClient", "wsRequest", "heartbeatJob", "webSocket", "url", "redirect", "baseUrl", "code", "fingerprint", "mouseData", "baseHeaders", "sessionJson", "sessionId", "cookieHeaders", "rebindJson", "rebindToken", "wsBaseUrl", "visibleTimeDone", "okHttpClient", "wsRequest", "heartbeatJob", "webSocket", "finalToken", "attempt", "url", "redirect", "baseUrl", "code", "fingerprint", "mouseData", "baseHeaders", "sessionJson", "sessionId", "cookieHeaders", "rebindJson", "rebindToken", "wsBaseUrl", "visibleTimeDone", "okHttpClient", "wsRequest", "heartbeatJob", "webSocket", "finalToken", "attempt", "url", "redirect", "baseUrl", "code", "fingerprint", "mouseData", "baseHeaders", "sessionJson", "sessionId", "cookieHeaders", "rebindJson", "rebindToken", "wsBaseUrl", "visibleTimeDone", "okHttpClient", "wsRequest", "heartbeatJob", "webSocket", "finalToken", "token"}, nl = {1646, 1682, 1697, 1774, 1796, 1802, 1811}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19"}, v = 2)
    static final class C02711 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$19;
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

        C02711(Continuation<? super C02711> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayUtilsKt.bypassXD(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayUtilsKt$convertTmdbToAnimeId$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayUtilsKt", f = "StreamPlayUtils.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {140, 142, 143}, m = "convertTmdbToAnimeId", n = {"title", "date", "airedDate", "type", "sDate", "sAiredDate", "year", "airedYear", "season", "airedSeason", "title", "date", "airedDate", "type", "sDate", "sAiredDate", "year", "airedYear", "season", "airedSeason", "title", "date", "airedDate", "type", "sDate", "sAiredDate", "year", "airedYear", "season", "airedSeason", "ids"}, nl = {150, 143, 150}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10"}, v = 2)
    static final class C02731 extends ContinuationImpl {
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

        C02731(Continuation<? super C02731> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayUtilsKt.convertTmdbToAnimeId(null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayUtilsKt$extractMdrive$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayUtilsKt", f = "StreamPlayUtils.kt", i = {0, 0}, l = {329}, m = "extractMdrive", n = {"url", "regex"}, nl = {330}, s = {"L$0", "L$1"}, v = 2)
    static final class C02741 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C02741(Continuation<? super C02741> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayUtilsKt.extractMdrive(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayUtilsKt$fetchTmdbLogoUrl$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayUtilsKt", f = "StreamPlayUtils.kt", i = {0, 0, 0, 0, 0, 0}, l = {1365}, m = "fetchTmdbLogoUrl", n = {"tmdbAPI", "apiKey", "type", "tmdbId", "appLangCode", "url"}, nl = {1365}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C02751 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C02751(Continuation<? super C02751> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayUtilsKt.fetchTmdbLogoUrl(null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayUtilsKt$getHindMoviezLinks$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayUtilsKt", f = "StreamPlayUtils.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {1435, 1453}, m = "getHindMoviezLinks", n = {"source", "url", "subtitleCallback", "callback", "source", "url", "subtitleCallback", "callback", "response", "doc", "name", "fileSize", "extractedSpecs", "quality"}, nl = {1436, 1511}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0"}, v = 2)
    static final class C02761 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        C02761(Continuation<? super C02761> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayUtilsKt.getHindMoviezLinks(null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayUtilsKt$getRedirectLinks$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayUtilsKt", f = "StreamPlayUtils.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {1083, 1098}, m = "getRedirectLinks", n = {"url", "url", "doc", "regex", "combinedString", "decodedString", "jsonObject", "encodedurl", "data", "wphttp1"}, nl = {1084, 1098}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 2)
    static final class C02791 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        C02791(Continuation<? super C02791> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayUtilsKt.getRedirectLinks(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayUtilsKt$hindmoviezsignHShare$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayUtilsKt", f = "StreamPlayUtils.kt", i = {0, 0, 0, 0, 0}, l = {1920}, m = "hindmoviezsignHShare", n = {"rawId", "domain", "pageDoc", "encoded", "ajaxUrl"}, nl = {1926}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
    static final class C02801 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C02801(Continuation<? super C02801> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayUtilsKt.hindmoviezsignHShare(null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayUtilsKt$invokeExternalSource$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayUtilsKt", f = "StreamPlayUtils.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {570, 573, 585, 595}, m = "invokeExternalSource", n = {"mediaId", "type", "season", "episode", "callback", "token", "thirdAPI", "fourthAPI", "seasonSlug", "episodeSlug", "headers", "mediaId", "type", "season", "episode", "callback", "token", "thirdAPI", "fourthAPI", "seasonSlug", "episodeSlug", "headers", "shareKey", "mediaId", "type", "season", "episode", "callback", "token", "thirdAPI", "fourthAPI", "seasonSlug", "episodeSlug", "headers", "shareKey", "shareRes", "parentId", "mediaId", "type", "season", "episode", "callback", "token", "thirdAPI", "fourthAPI", "seasonSlug", "episodeSlug", "headers", "shareKey", "shareRes", "fids"}, nl = {571, 574, 589, 661}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13"}, v = 2)
    static final class C02821 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
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

        C02821(Continuation<? super C02821> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayUtilsKt.invokeExternalSource(null, null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayUtilsKt$loadDisplaySourceNameExtractor$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayUtilsKt", f = "StreamPlayUtils.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {259}, m = "loadDisplaySourceNameExtractor", n = {"sourceName", "displayName", "url", "referer", "subtitleCallback", "callback", "quality"}, nl = {276}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
    static final class C02851 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C02851(Continuation<? super C02851> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayUtilsKt.loadDisplaySourceNameExtractor(null, null, null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayUtilsKt$loadSourceNameExtractor$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayUtilsKt", f = "StreamPlayUtils.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {218}, m = "loadSourceNameExtractor", n = {"source", "url", "referer", "subtitleCallback", "callback", "quality", "size", "provider", "sizePart"}, nl = {247}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 2)
    static final class C02871 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        C02871(Continuation<? super C02871> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayUtilsKt.loadSourceNameExtractor(null, null, null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayUtilsKt$retry$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayUtilsKt", f = "StreamPlayUtils.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {2097, 2102, 2106}, m = "retry", n = {"block", "times", "delayMs", "it", "block", "times", "delayMs", "it", "block", "times", "delayMs"}, nl = {2096, 2103, 2105}, s = {"L$0", "I$0", "J$0", "I$3", "L$0", "I$0", "J$0", "I$3", "L$0", "I$0", "J$0"}, v = 2)
    static final class C02891<T> extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C02891(Continuation<? super C02891> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayUtilsKt.retry(0, 0L, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayUtilsKt$safeAmap$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 176)
    @DebugMetadata(c = "com.phisher98.StreamPlayUtilsKt", f = "StreamPlayUtils.kt", i = {0, 0, 0, 0}, l = {1884}, m = "safeAmap", n = {"$this$safeAmap", "f", "$this$safeAmap_u24lambda_u240", "concurrency"}, nl = {1899}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$1\n*L\n1#1,2265:1\n*E\n"})
    static final class C02911<A, B> extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C02911(Continuation<? super C02911> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objSafeAmap = StreamPlayUtilsKt.safeAmap(null, 0, null, (Continuation) this);
            return objSafeAmap == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSafeAmap : Result.box-impl(objSafeAmap);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayUtilsKt$safeGet$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayUtilsKt", f = "StreamPlayUtils.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {2266, 1823}, m = "safeGet", n = {"url", "headers", "referer", "timeout", "interceptor", "$this$withPermit$iv", "allowRedirects", "cacheTime", "url", "headers", "referer", "timeout", "interceptor", "$this$withPermit$iv", "allowRedirects", "cacheTime"}, nl = {2267, 1831}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "I$0"}, v = 2)
    static final class C02921 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C02921(Continuation<? super C02921> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayUtilsKt.safeGet(null, null, null, null, null, false, 0, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayUtilsKt$tmdbToAnimeId$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayUtilsKt", f = "StreamPlayUtils.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {189}, m = "tmdbToAnimeId", n = {"title", "year", "season", "type", "query", "variables", "data"}, nl = {190}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
    static final class C02931 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C02931(Continuation<? super C02931> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayUtilsKt.tmdbToAnimeId(null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayUtilsKt$yflixDecode$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayUtilsKt", f = "StreamPlayUtils.kt", i = {0}, l = {1309}, m = "yflixDecode", n = {"text"}, nl = {1310}, s = {"L$0"}, v = 2)
    static final class C02941 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C02941(Continuation<? super C02941> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayUtilsKt.yflixDecode(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayUtilsKt$yflixDecodeReverse$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayUtilsKt", f = "StreamPlayUtils.kt", i = {0, 0}, l = {1322}, m = "yflixDecodeReverse", n = {"text", "jsonBody"}, nl = {1325}, s = {"L$0", "L$1"}, v = 2)
    static final class C02951 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C02951(Continuation<? super C02951> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StreamPlayUtilsKt.yflixDecodeReverse(null, (Continuation) this);
        }
    }

    @Nullable
    public static final SharedPreferences getSharedPref() {
        return sharedPref;
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.phisher98.StreamPlayUtilsKt$tmdbDateFormatter$1] */
    static {
        SharedPreferences sharedPreferences = sharedPref;
        appGlobalSemaphore = SemaphoreKt.Semaphore$default(sharedPreferences != null ? RangesKt.coerceIn(sharedPreferences.getInt("provider_concurrency", 15), 8, 50) : 20, 0, 2, (Object) null);
        extractorCallbackScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        sharedObjectMapper$delegate = LazyKt.lazy(new Function0() { // from class: com.phisher98.StreamPlayUtilsKt$$ExternalSyntheticLambda9
            public final Object invoke() {
                return StreamPlayUtilsKt.sharedObjectMapper_delegate$lambda$0();
            }
        });
        sharedGson$delegate = LazyKt.lazy(new Function0() { // from class: com.phisher98.StreamPlayUtilsKt$$ExternalSyntheticLambda14
            public final Object invoke() {
                return StreamPlayUtilsKt.sharedGson_delegate$lambda$0();
            }
        });
        tmdbDateFormatter = new ThreadLocal<SimpleDateFormat>() { // from class: com.phisher98.StreamPlayUtilsKt$tmdbDateFormatter$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            public SimpleDateFormat initialValue() {
                return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            }
        };
        languageMap = MapsKt.mapOf(new Pair[]{TuplesKt.to("Afrikaans", SetsKt.setOf(new String[]{"af", "afr"})), TuplesKt.to("Albanian", SetsKt.setOf(new String[]{"sq", "sqi", "alb"})), TuplesKt.to("Amharic", SetsKt.setOf(new String[]{"am", "amh"})), TuplesKt.to("Arabic", SetsKt.setOf(new String[]{"ar", "ara"})), TuplesKt.to("Armenian", SetsKt.setOf(new String[]{"hy", "hye", "arm"})), TuplesKt.to("Azerbaijani", SetsKt.setOf(new String[]{"az", "aze"})), TuplesKt.to("Basque", SetsKt.setOf(new String[]{"eu", "eus", "baq"})), TuplesKt.to("Belarusian", SetsKt.setOf(new String[]{"be", "bel"})), TuplesKt.to("Bengali", SetsKt.setOf(new String[]{"bn", "ben"})), TuplesKt.to("Bosnian", SetsKt.setOf(new String[]{"bs", "bos"})), TuplesKt.to("Bulgarian", SetsKt.setOf(new String[]{"bg", "bul"})), TuplesKt.to("Catalan", SetsKt.setOf(new String[]{"ca", "cat"})), TuplesKt.to("Chinese", SetsKt.setOf(new String[]{"zh", "zho", "chi"})), TuplesKt.to("Croatian", SetsKt.setOf(new String[]{"hr", "hrv", "scr"})), TuplesKt.to("Czech", SetsKt.setOf(new String[]{"cs", "ces", "cze"})), TuplesKt.to("Danish", SetsKt.setOf(new String[]{"da", "dan"})), TuplesKt.to("Dutch", SetsKt.setOf(new String[]{"nl", "nld", "dut"})), TuplesKt.to("English", SetsKt.setOf(new String[]{"en", "eng"})), TuplesKt.to("Estonian", SetsKt.setOf(new String[]{"et", "est"})), TuplesKt.to("Filipino", SetsKt.setOf(new String[]{"tl", "tgl"})), TuplesKt.to("Finnish", SetsKt.setOf(new String[]{"fi", "fin"})), TuplesKt.to("French", SetsKt.setOf(new String[]{"fr", "fra", "fre"})), TuplesKt.to("Galician", SetsKt.setOf(new String[]{"gl", "glg"})), TuplesKt.to("Georgian", SetsKt.setOf(new String[]{"ka", "kat", "geo"})), TuplesKt.to("German", SetsKt.setOf(new String[]{"de", "deu", "ger"})), TuplesKt.to("Greek", SetsKt.setOf(new String[]{"el", "ell", "gre"})), TuplesKt.to("Gujarati", SetsKt.setOf(new String[]{"gu", "guj"})), TuplesKt.to("Hebrew", SetsKt.setOf(new String[]{"he", "heb"})), TuplesKt.to("Hindi", SetsKt.setOf(new String[]{"hi", "hin"})), TuplesKt.to("Hungarian", SetsKt.setOf(new String[]{"hu", "hun"})), TuplesKt.to("Icelandic", SetsKt.setOf(new String[]{"is", "isl", "ice"})), TuplesKt.to("Indonesian", SetsKt.setOf(new String[]{"id", "ind"})), TuplesKt.to("Italian", SetsKt.setOf(new String[]{"it", "ita"})), TuplesKt.to("Japanese", SetsKt.setOf(new String[]{"ja", "jpn"})), TuplesKt.to("Kannada", SetsKt.setOf(new String[]{"kn", "kan"})), TuplesKt.to("Kazakh", SetsKt.setOf(new String[]{"kk", "kaz"})), TuplesKt.to("Korean", SetsKt.setOf(new String[]{"ko", "kor"})), TuplesKt.to("Latvian", SetsKt.setOf(new String[]{"lv", "lav"})), TuplesKt.to("Lithuanian", SetsKt.setOf(new String[]{"lt", "lit"})), TuplesKt.to("Macedonian", SetsKt.setOf(new String[]{"mk", "mkd", "mac"})), TuplesKt.to("Malay", SetsKt.setOf(new String[]{"ms", "msa", "may"})), TuplesKt.to("Malayalam", SetsKt.setOf(new String[]{"ml", "mal"})), TuplesKt.to("Maltese", SetsKt.setOf(new String[]{"mt", "mlt"})), TuplesKt.to("Marathi", SetsKt.setOf(new String[]{"mr", "mar"})), TuplesKt.to("Mongolian", SetsKt.setOf(new String[]{"mn", "mon"})), TuplesKt.to("Nepali", SetsKt.setOf(new String[]{"ne", "nep"})), TuplesKt.to("Norwegian", SetsKt.setOf(new String[]{"no", "nor"})), TuplesKt.to("Persian", SetsKt.setOf(new String[]{"fa", "fas", "per"})), TuplesKt.to("Polish", SetsKt.setOf(new String[]{"pl", "pol"})), TuplesKt.to("Portuguese", SetsKt.setOf(new String[]{"pt", "por"})), TuplesKt.to("Punjabi", SetsKt.setOf(new String[]{"pa", "pan"})), TuplesKt.to("Romanian", SetsKt.setOf(new String[]{"ro", "ron", "rum"})), TuplesKt.to("Russian", SetsKt.setOf(new String[]{"ru", "rus"})), TuplesKt.to("Serbian", SetsKt.setOf(new String[]{"sr", "srp", "scc"})), TuplesKt.to("Sinhala", SetsKt.setOf(new String[]{"si", "sin"})), TuplesKt.to("Slovak", SetsKt.setOf(new String[]{"sk", "slk", "slo"})), TuplesKt.to("Slovenian", SetsKt.setOf(new String[]{"sl", "slv"})), TuplesKt.to("Spanish", SetsKt.setOf(new String[]{"es", "spa"})), TuplesKt.to("Swahili", SetsKt.setOf(new String[]{"sw", "swa"})), TuplesKt.to("Swedish", SetsKt.setOf(new String[]{"sv", "swe"})), TuplesKt.to("Tamil", SetsKt.setOf(new String[]{"ta", "tam"})), TuplesKt.to("Telugu", SetsKt.setOf(new String[]{"te", "tel"})), TuplesKt.to("Thai", SetsKt.setOf(new String[]{"th", "tha"})), TuplesKt.to("Turkish", SetsKt.setOf(new String[]{"tr", "tur"})), TuplesKt.to("Ukrainian", SetsKt.setOf(new String[]{"uk", "ukr"})), TuplesKt.to("Urdu", SetsKt.setOf(new String[]{"ur", "urd"})), TuplesKt.to("Uzbek", SetsKt.setOf(new String[]{"uz", "uzb"})), TuplesKt.to("Vietnamese", SetsKt.setOf(new String[]{"vi", "vie"})), TuplesKt.to("Welsh", SetsKt.setOf(new String[]{"cy", "cym", "wel"})), TuplesKt.to("Yiddish", SetsKt.setOf(new String[]{"yi", "yid"}))});
        decryptMethods = MapsKt.mapOf(new Pair[]{TuplesKt.to("TsA2KGDGux", new Function1() { // from class: com.phisher98.StreamPlayUtilsKt$$ExternalSyntheticLambda15
            public final Object invoke(Object obj) {
                return StreamPlayUtilsKt.decryptMethods$lambda$0((String) obj);
            }
        }), TuplesKt.to("ux8qjPHC66", new Function1() { // from class: com.phisher98.StreamPlayUtilsKt$$ExternalSyntheticLambda16
            public final Object invoke(Object obj) {
                return StreamPlayUtilsKt.decryptMethods$lambda$1((String) obj);
            }
        }), TuplesKt.to("xTyBxQyGTA", new Function1() { // from class: com.phisher98.StreamPlayUtilsKt$$ExternalSyntheticLambda17
            public final Object invoke(Object obj) {
                return StreamPlayUtilsKt.decryptMethods$lambda$2((String) obj);
            }
        }), TuplesKt.to("IhWrImMIGL", new Function1() { // from class: com.phisher98.StreamPlayUtilsKt$$ExternalSyntheticLambda18
            public final Object invoke(Object obj) {
                return StreamPlayUtilsKt.decryptMethods$lambda$3((String) obj);
            }
        }), TuplesKt.to("o2VSUnjnZl", new Function1() { // from class: com.phisher98.StreamPlayUtilsKt$$ExternalSyntheticLambda19
            public final Object invoke(Object obj) {
                return StreamPlayUtilsKt.decryptMethods$lambda$4((String) obj);
            }
        }), TuplesKt.to("eSfH1IRMyL", new Function1() { // from class: com.phisher98.StreamPlayUtilsKt$$ExternalSyntheticLambda20
            public final Object invoke(Object obj) {
                return StreamPlayUtilsKt.decryptMethods$lambda$5((String) obj);
            }
        }), TuplesKt.to("Oi3v1dAlaM", new Function1() { // from class: com.phisher98.StreamPlayUtilsKt$$ExternalSyntheticLambda21
            public final Object invoke(Object obj) {
                return StreamPlayUtilsKt.decryptMethods$lambda$6((String) obj);
            }
        }), TuplesKt.to("sXnL9MQIry", new Function1() { // from class: com.phisher98.StreamPlayUtilsKt$$ExternalSyntheticLambda22
            public final Object invoke(Object obj) {
                return StreamPlayUtilsKt.decryptMethods$lambda$7((String) obj);
            }
        }), TuplesKt.to("JoAHUMCLXV", new Function1() { // from class: com.phisher98.StreamPlayUtilsKt$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                return StreamPlayUtilsKt.decryptMethods$lambda$8((String) obj);
            }
        }), TuplesKt.to("KJHidj7det", new Function1() { // from class: com.phisher98.StreamPlayUtilsKt$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                return StreamPlayUtilsKt.decryptMethods$lambda$9((String) obj);
            }
        }), TuplesKt.to("playerjs", new Function1() { // from class: com.phisher98.StreamPlayUtilsKt$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                return StreamPlayUtilsKt.decryptMethods$lambda$10((String) obj);
            }
        })});
        JSON = MediaType.Companion.get("application/json; charset=utf-8");
        ORDERED_SPEC_CATEGORIES = CollectionsKt.listOf(new String[]{"quality", "codec", "audio", "hdr", "language"});
        FILE_SIZE_REGEX = new Regex("(\\d+(?:\\.\\d+)?\\s?(?:MB|GB))", RegexOption.IGNORE_CASE);
        SPEC_OPTIONS = MapsKt.mapOf(new Pair[]{TuplesKt.to("quality", CollectionsKt.listOf(new Map[]{MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "BluRay"), TuplesKt.to("label", "BluRay")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "BluRay REMUX"), TuplesKt.to("label", "BluRay REMUX")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "BRRip"), TuplesKt.to("label", "BRRip")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "BDRip"), TuplesKt.to("label", "BDRip")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "WEB-DL"), TuplesKt.to("label", "WEB-DL")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "HDRip"), TuplesKt.to("label", "HDRip")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "DVDRip"), TuplesKt.to("label", "DVDRip")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "HDTV"), TuplesKt.to("label", "HDTV")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "CAM"), TuplesKt.to("label", "CAM")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "TeleSync"), TuplesKt.to("label", "TeleSync")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "SCR"), TuplesKt.to("label", "SCR")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "10bit"), TuplesKt.to("label", "10bit")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "8bit"), TuplesKt.to("label", "8bit")})})), TuplesKt.to("codec", CollectionsKt.listOf(new Map[]{MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "x264"), TuplesKt.to("label", "x264")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "x265"), TuplesKt.to("label", "x265 (HEVC)")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "h.264"), TuplesKt.to("label", "H.264 (AVC)")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "h.265"), TuplesKt.to("label", "H.265 (HEVC)")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "hevc"), TuplesKt.to("label", "HEVC")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "avc"), TuplesKt.to("label", "AVC")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "mpeg-2"), TuplesKt.to("label", "MPEG-2")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "mpeg-4"), TuplesKt.to("label", "MPEG-4")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "vp9"), TuplesKt.to("label", "VP9")})})), TuplesKt.to("audio", CollectionsKt.listOf(new Map[]{MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "AAC"), TuplesKt.to("label", "AAC")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "AC3"), TuplesKt.to("label", "AC3 (Dolby Digital)")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "DTS"), TuplesKt.to("label", "DTS")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "DTS-HD MA"), TuplesKt.to("label", "DTS-HD MA")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "TrueHD"), TuplesKt.to("label", "Dolby TrueHD")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "Atmos"), TuplesKt.to("label", "Dolby Atmos")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "DD+"), TuplesKt.to("label", "DD+")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "Dolby Digital Plus"), TuplesKt.to("label", "Dolby Digital Plus")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "DTS Lossless"), TuplesKt.to("label", "DTS Lossless")})})), TuplesKt.to("hdr", CollectionsKt.listOf(new Map[]{MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "DV"), TuplesKt.to("label", "Dolby Vision")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "HDR10+"), TuplesKt.to("label", "HDR10+")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "HDR"), TuplesKt.to("label", "HDR")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "SDR"), TuplesKt.to("label", "SDR")})})), TuplesKt.to("language", CollectionsKt.listOf(new Map[]{MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "HIN"), TuplesKt.to("label", "Hindi🇮🇳")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "Hindi"), TuplesKt.to("label", "Hindi🇮🇳")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "Tamil"), TuplesKt.to("label", "Tamil🇮🇳")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "ENG"), TuplesKt.to("label", "English🇺🇸")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "English"), TuplesKt.to("label", "English🇺🇸")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "Korean"), TuplesKt.to("label", "Korean🇰🇷")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "KOR"), TuplesKt.to("label", "Korean🇰🇷")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "Japanese"), TuplesKt.to("label", "Japanese🇯🇵")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "Chinese"), TuplesKt.to("label", "Chinese🇨🇳")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "Telugu"), TuplesKt.to("label", "Telugu🇮🇳")})}))});
        Map<String, List<Map<String, String>>> map = SPEC_OPTIONS;
        int $i$f$mapValues = 0;
        Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Map<String, List<Map<String, String>>> map2 = map;
        int $i$f$mapValuesTo = 0;
        Iterable $this$associateByTo$iv$iv$iv = map2.entrySet();
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
            Object key = it$iv$iv.getKey();
            Iterable options = (List) ((Map.Entry) element$iv$iv$iv).getValue();
            Iterable $this$map$iv = options;
            Map<String, List<Map<String, String>>> map3 = map;
            int $i$f$mapValues2 = $i$f$mapValues;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            Iterable $this$mapTo$iv$iv = $this$map$iv;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                Iterable $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                Map option = (Map) item$iv$iv;
                Map destination$iv$iv3 = destination$iv$iv;
                Object obj = option.get("value");
                Map<String, List<Map<String, String>>> map4 = map2;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                String value = (String) obj;
                Object obj2 = option.get("label");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                String label = (String) obj2;
                destination$iv$iv2.add(TuplesKt.to(label, new Regex("\\b" + Regex.Companion.escape(value) + "\\b", RegexOption.IGNORE_CASE)));
                $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                destination$iv$iv = destination$iv$iv3;
                map2 = map4;
                $i$f$mapValuesTo = $i$f$mapValuesTo;
                $this$associateByTo$iv$iv$iv = $this$associateByTo$iv$iv$iv;
            }
            destination$iv$iv.put(key, (List) destination$iv$iv2);
            map = map3;
            $i$f$mapValues = $i$f$mapValues2;
        }
        SPEC_REGEX_CACHE = destination$iv$iv;
        BROWSER_FINGERPRINT$delegate = LazyKt.lazy(new Function0() { // from class: com.phisher98.StreamPlayUtilsKt$$ExternalSyntheticLambda13
            public final Object invoke() {
                return StreamPlayUtilsKt.BROWSER_FINGERPRINT_delegate$lambda$0();
            }
        });
    }

    @NotNull
    public static final Semaphore getAppGlobalSemaphore() {
        return appGlobalSemaphore;
    }

    private static final ObjectMapper getSharedObjectMapper() {
        return (ObjectMapper) sharedObjectMapper$delegate.getValue();
    }

    static final ObjectMapper sharedObjectMapper_delegate$lambda$0() {
        return new ObjectMapper();
    }

    private static final Gson getSharedGson() {
        return (Gson) sharedGson$delegate.getValue();
    }

    static final Gson sharedGson_delegate$lambda$0() {
        return new Gson();
    }

    private static final SimpleDateFormat getTmdbDateFormatter() {
        SimpleDateFormat simpleDateFormat = tmdbDateFormatter.get();
        Intrinsics.checkNotNull(simpleDateFormat);
        return simpleDateFormat;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0190 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0191  */
    /* JADX WARN: Code duplicated, block: B:27:0x01e7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:31:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:35:0x020f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0218  */
    /* JADX WARN: Code duplicated, block: B:39:0x0299 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:45:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:48:0x02c3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:52:0x0307 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:53:0x0308  */
    /* JADX WARN: Code duplicated, block: B:56:0x0330 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:57:0x0331  */
    /* JADX WARN: Code duplicated, block: B:59:0x033a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Nullable
    public static final Object bypassHrefli(@NotNull String url, @NotNull Continuation<? super String> continuation) {
        C02701 c02701;
        int i;
        Object obj;
        C02701 c02702;
        String url2;
        String host;
        String host2;
        C02701 c02703;
        String formUrl;
        String formUrl2;
        Map<String, String> mapBypassHrefli$getFormData;
        String host3;
        C02701 c02704;
        String formUrl3;
        Map<String, String> map;
        String host4;
        Document res;
        Element elementSelectFirst;
        String strData;
        String strSubstringAfter$default;
        String skToken;
        String host5;
        Map<String, String> map2;
        String skToken2;
        Document res2;
        C02701 c02705;
        Element elementSelectFirst2;
        String driveUrl;
        Requests app;
        String strAttr;
        String path;
        if (continuation instanceof C02701) {
            c02701 = (C02701) continuation;
            if ((c02701.label & Integer.MIN_VALUE) != 0) {
                c02701.label -= Integer.MIN_VALUE;
            } else {
                c02701 = new C02701(continuation);
            }
        } else {
            c02701 = new C02701(continuation);
        }
        Object $result = c02701.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c02701.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String host6 = getBaseUrl(url);
                Requests app2 = MainActivityKt.getApp();
                c02701.L$0 = SpillingKt.nullOutSpilledVariable(url);
                c02701.L$1 = host6;
                c02701.label = 1;
                i = 2;
                C02701 c02706 = c02701;
                obj = coroutine_suspended;
                $result = Requests.get$default(app2, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02706, 4094, (Object) null);
                c02702 = c02706;
                if ($result == obj) {
                    return obj;
                }
                url2 = url;
                host = host6;
                Document res3 = ((NiceResponse) $result).getDocument();
                String formUrl4 = bypassHrefli$getFormUrl(res3);
                Map<String, String> mapBypassHrefli$getFormData2 = bypassHrefli$getFormData(res3);
                Requests app3 = MainActivityKt.getApp();
                c02702.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c02702.L$1 = host;
                c02702.L$2 = SpillingKt.nullOutSpilledVariable(res3);
                c02702.L$3 = SpillingKt.nullOutSpilledVariable(formUrl4);
                c02702.L$4 = SpillingKt.nullOutSpilledVariable(mapBypassHrefli$getFormData2);
                c02702.label = i;
                host2 = host;
                C02701 c02707 = c02702;
                $result = Requests.post$default(app3, formUrl4, (Map) null, (String) null, (Map) null, (Map) null, mapBypassHrefli$getFormData2, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02707, 65502, (Object) null);
                c02703 = c02707;
                if ($result == obj) {
                    return obj;
                }
                formUrl = host2;
                Document res4 = ((NiceResponse) $result).getDocument();
                formUrl2 = bypassHrefli$getFormUrl(res4);
                mapBypassHrefli$getFormData = bypassHrefli$getFormData(res4);
                Requests app4 = MainActivityKt.getApp();
                c02703.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c02703.L$1 = formUrl;
                c02703.L$2 = SpillingKt.nullOutSpilledVariable(res4);
                c02703.L$3 = SpillingKt.nullOutSpilledVariable(formUrl2);
                c02703.L$4 = mapBypassHrefli$getFormData;
                c02703.label = 3;
                C02701 c02708 = c02703;
                host3 = formUrl;
                $result = Requests.post$default(app4, formUrl2, (Map) null, (String) null, (Map) null, (Map) null, mapBypassHrefli$getFormData, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02708, 65502, (Object) null);
                c02704 = c02708;
                if ($result == obj) {
                    return obj;
                }
                formUrl3 = formUrl2;
                map = mapBypassHrefli$getFormData;
                host4 = host3;
                res = ((NiceResponse) $result).getDocument();
                elementSelectFirst = res.selectFirst("script:containsData(?go=)");
                if (elementSelectFirst != null && (strData = elementSelectFirst.data()) != null) {
                    strSubstringAfter$default = StringsKt.substringAfter$default(strData, "?go=", (String) null, i, (Object) null);
                    if (strSubstringAfter$default != null) {
                        return null;
                    }
                    skToken = StringsKt.substringBefore$default(strSubstringAfter$default, "\"", (String) null, i, (Object) null);
                    if (skToken != null) {
                        Map mapMapOf = MapsKt.mapOf(TuplesKt.to(skToken, String.valueOf(map.get("_wp_http2"))));
                        c02704.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        c02704.L$1 = SpillingKt.nullOutSpilledVariable(host4);
                        c02704.L$2 = SpillingKt.nullOutSpilledVariable(res);
                        c02704.L$3 = SpillingKt.nullOutSpilledVariable(formUrl3);
                        c02704.L$4 = SpillingKt.nullOutSpilledVariable(map);
                        c02704.L$5 = SpillingKt.nullOutSpilledVariable(skToken);
                        c02704.label = 4;
                        C02701 c02709 = c02704;
                        host5 = host4;
                        map2 = map;
                        skToken2 = skToken;
                        res2 = res;
                        $result = Requests.get$default(MainActivityKt.getApp(), host4 + "?go=" + skToken, (Map) null, (String) null, (Map) null, mapMapOf, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02709, 4078, (Object) null);
                        c02705 = c02709;
                        if ($result == obj) {
                            return obj;
                        }
                        elementSelectFirst2 = ((NiceResponse) $result).getDocument().selectFirst("meta[http-equiv=refresh]");
                        if (elementSelectFirst2 != null || (strAttr = elementSelectFirst2.attr("content")) == null) {
                            driveUrl = null;
                        } else {
                            driveUrl = StringsKt.substringAfter$default(strAttr, "url=", (String) null, i, (Object) null);
                        }
                        app = MainActivityKt.getApp();
                        if (driveUrl == null) {
                            return null;
                        }
                        c02705.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        c02705.L$1 = SpillingKt.nullOutSpilledVariable(host5);
                        c02705.L$2 = SpillingKt.nullOutSpilledVariable(res2);
                        c02705.L$3 = SpillingKt.nullOutSpilledVariable(formUrl3);
                        c02705.L$4 = SpillingKt.nullOutSpilledVariable(map2);
                        c02705.L$5 = SpillingKt.nullOutSpilledVariable(skToken2);
                        c02705.L$6 = driveUrl;
                        c02705.label = 5;
                        $result = Requests.get$default(app, driveUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02705, 4094, (Object) null);
                        if ($result == obj) {
                            return obj;
                        }
                        path = StringsKt.substringBefore$default(StringsKt.substringAfter$default(((NiceResponse) $result).getText(), "replace(\"", (String) null, i, (Object) null), "\")", (String) null, i, (Object) null);
                        if (Intrinsics.areEqual(path, "/404")) {
                            return null;
                        }
                        return fixUrl(path, getBaseUrl(driveUrl));
                    }
                }
                return null;
            case 1:
                host = (String) c02701.L$1;
                String url3 = (String) c02701.L$0;
                ResultKt.throwOnFailure($result);
                c02702 = c02701;
                obj = coroutine_suspended;
                url2 = url3;
                i = 2;
                Document res5 = ((NiceResponse) $result).getDocument();
                String formUrl5 = bypassHrefli$getFormUrl(res5);
                Map<String, String> mapBypassHrefli$getFormData3 = bypassHrefli$getFormData(res5);
                Requests app5 = MainActivityKt.getApp();
                c02702.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c02702.L$1 = host;
                c02702.L$2 = SpillingKt.nullOutSpilledVariable(res5);
                c02702.L$3 = SpillingKt.nullOutSpilledVariable(formUrl5);
                c02702.L$4 = SpillingKt.nullOutSpilledVariable(mapBypassHrefli$getFormData3);
                c02702.label = i;
                host2 = host;
                C02701 c027010 = c02702;
                $result = Requests.post$default(app5, formUrl5, (Map) null, (String) null, (Map) null, (Map) null, mapBypassHrefli$getFormData3, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c027010, 65502, (Object) null);
                c02703 = c027010;
                if ($result == obj) {
                    return obj;
                }
                formUrl = host2;
                Document res6 = ((NiceResponse) $result).getDocument();
                formUrl2 = bypassHrefli$getFormUrl(res6);
                mapBypassHrefli$getFormData = bypassHrefli$getFormData(res6);
                Requests app6 = MainActivityKt.getApp();
                c02703.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c02703.L$1 = formUrl;
                c02703.L$2 = SpillingKt.nullOutSpilledVariable(res6);
                c02703.L$3 = SpillingKt.nullOutSpilledVariable(formUrl2);
                c02703.L$4 = mapBypassHrefli$getFormData;
                c02703.label = 3;
                C02701 c027011 = c02703;
                host3 = formUrl;
                $result = Requests.post$default(app6, formUrl2, (Map) null, (String) null, (Map) null, (Map) null, mapBypassHrefli$getFormData, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c027011, 65502, (Object) null);
                c02704 = c027011;
                if ($result == obj) {
                    return obj;
                }
                formUrl3 = formUrl2;
                map = mapBypassHrefli$getFormData;
                host4 = host3;
                res = ((NiceResponse) $result).getDocument();
                elementSelectFirst = res.selectFirst("script:containsData(?go=)");
                if (elementSelectFirst != null) {
                    strSubstringAfter$default = StringsKt.substringAfter$default(strData, "?go=", (String) null, i, (Object) null);
                    if (strSubstringAfter$default != null) {
                        return null;
                    }
                    skToken = StringsKt.substringBefore$default(strSubstringAfter$default, "\"", (String) null, i, (Object) null);
                    if (skToken != null) {
                        Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to(skToken, String.valueOf(map.get("_wp_http2"))));
                        c02704.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        c02704.L$1 = SpillingKt.nullOutSpilledVariable(host4);
                        c02704.L$2 = SpillingKt.nullOutSpilledVariable(res);
                        c02704.L$3 = SpillingKt.nullOutSpilledVariable(formUrl3);
                        c02704.L$4 = SpillingKt.nullOutSpilledVariable(map);
                        c02704.L$5 = SpillingKt.nullOutSpilledVariable(skToken);
                        c02704.label = 4;
                        C02701 c027012 = c02704;
                        host5 = host4;
                        map2 = map;
                        skToken2 = skToken;
                        res2 = res;
                        $result = Requests.get$default(MainActivityKt.getApp(), host4 + "?go=" + skToken, (Map) null, (String) null, (Map) null, mapMapOf2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c027012, 4078, (Object) null);
                        c02705 = c027012;
                        if ($result == obj) {
                            return obj;
                        }
                        elementSelectFirst2 = ((NiceResponse) $result).getDocument().selectFirst("meta[http-equiv=refresh]");
                        if (elementSelectFirst2 != null) {
                            driveUrl = null;
                        } else {
                            driveUrl = null;
                        }
                        app = MainActivityKt.getApp();
                        if (driveUrl == null) {
                            return null;
                        }
                        c02705.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        c02705.L$1 = SpillingKt.nullOutSpilledVariable(host5);
                        c02705.L$2 = SpillingKt.nullOutSpilledVariable(res2);
                        c02705.L$3 = SpillingKt.nullOutSpilledVariable(formUrl3);
                        c02705.L$4 = SpillingKt.nullOutSpilledVariable(map2);
                        c02705.L$5 = SpillingKt.nullOutSpilledVariable(skToken2);
                        c02705.L$6 = driveUrl;
                        c02705.label = 5;
                        $result = Requests.get$default(app, driveUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02705, 4094, (Object) null);
                        if ($result == obj) {
                            return obj;
                        }
                        path = StringsKt.substringBefore$default(StringsKt.substringAfter$default(((NiceResponse) $result).getText(), "replace(\"", (String) null, i, (Object) null), "\")", (String) null, i, (Object) null);
                        if (Intrinsics.areEqual(path, "/404")) {
                            return null;
                        }
                        return fixUrl(path, getBaseUrl(driveUrl));
                    }
                }
                return null;
            case 2:
                String host7 = (String) c02701.L$1;
                String url4 = (String) c02701.L$0;
                ResultKt.throwOnFailure($result);
                url2 = url4;
                i = 2;
                c02703 = c02701;
                obj = coroutine_suspended;
                formUrl = host7;
                Document res7 = ((NiceResponse) $result).getDocument();
                formUrl2 = bypassHrefli$getFormUrl(res7);
                mapBypassHrefli$getFormData = bypassHrefli$getFormData(res7);
                Requests app7 = MainActivityKt.getApp();
                c02703.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c02703.L$1 = formUrl;
                c02703.L$2 = SpillingKt.nullOutSpilledVariable(res7);
                c02703.L$3 = SpillingKt.nullOutSpilledVariable(formUrl2);
                c02703.L$4 = mapBypassHrefli$getFormData;
                c02703.label = 3;
                C02701 c027013 = c02703;
                host3 = formUrl;
                $result = Requests.post$default(app7, formUrl2, (Map) null, (String) null, (Map) null, (Map) null, mapBypassHrefli$getFormData, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c027013, 65502, (Object) null);
                c02704 = c027013;
                if ($result == obj) {
                    return obj;
                }
                formUrl3 = formUrl2;
                map = mapBypassHrefli$getFormData;
                host4 = host3;
                res = ((NiceResponse) $result).getDocument();
                elementSelectFirst = res.selectFirst("script:containsData(?go=)");
                if (elementSelectFirst != null) {
                    strSubstringAfter$default = StringsKt.substringAfter$default(strData, "?go=", (String) null, i, (Object) null);
                    if (strSubstringAfter$default != null) {
                        return null;
                    }
                    skToken = StringsKt.substringBefore$default(strSubstringAfter$default, "\"", (String) null, i, (Object) null);
                    if (skToken != null) {
                        Map mapMapOf3 = MapsKt.mapOf(TuplesKt.to(skToken, String.valueOf(map.get("_wp_http2"))));
                        c02704.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        c02704.L$1 = SpillingKt.nullOutSpilledVariable(host4);
                        c02704.L$2 = SpillingKt.nullOutSpilledVariable(res);
                        c02704.L$3 = SpillingKt.nullOutSpilledVariable(formUrl3);
                        c02704.L$4 = SpillingKt.nullOutSpilledVariable(map);
                        c02704.L$5 = SpillingKt.nullOutSpilledVariable(skToken);
                        c02704.label = 4;
                        C02701 c027014 = c02704;
                        host5 = host4;
                        map2 = map;
                        skToken2 = skToken;
                        res2 = res;
                        $result = Requests.get$default(MainActivityKt.getApp(), host4 + "?go=" + skToken, (Map) null, (String) null, (Map) null, mapMapOf3, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c027014, 4078, (Object) null);
                        c02705 = c027014;
                        if ($result == obj) {
                            return obj;
                        }
                        elementSelectFirst2 = ((NiceResponse) $result).getDocument().selectFirst("meta[http-equiv=refresh]");
                        if (elementSelectFirst2 != null) {
                            driveUrl = null;
                        } else {
                            driveUrl = null;
                        }
                        app = MainActivityKt.getApp();
                        if (driveUrl == null) {
                            return null;
                        }
                        c02705.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        c02705.L$1 = SpillingKt.nullOutSpilledVariable(host5);
                        c02705.L$2 = SpillingKt.nullOutSpilledVariable(res2);
                        c02705.L$3 = SpillingKt.nullOutSpilledVariable(formUrl3);
                        c02705.L$4 = SpillingKt.nullOutSpilledVariable(map2);
                        c02705.L$5 = SpillingKt.nullOutSpilledVariable(skToken2);
                        c02705.L$6 = driveUrl;
                        c02705.label = 5;
                        $result = Requests.get$default(app, driveUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02705, 4094, (Object) null);
                        if ($result == obj) {
                            return obj;
                        }
                        path = StringsKt.substringBefore$default(StringsKt.substringAfter$default(((NiceResponse) $result).getText(), "replace(\"", (String) null, i, (Object) null), "\")", (String) null, i, (Object) null);
                        if (Intrinsics.areEqual(path, "/404")) {
                            return null;
                        }
                        return fixUrl(path, getBaseUrl(driveUrl));
                    }
                }
                return null;
            case 3:
                Map<String, String> map3 = (Map) c02701.L$4;
                String formUrl6 = (String) c02701.L$3;
                String host8 = (String) c02701.L$1;
                String url5 = (String) c02701.L$0;
                ResultKt.throwOnFailure($result);
                c02704 = c02701;
                obj = coroutine_suspended;
                map = map3;
                formUrl3 = formUrl6;
                host4 = host8;
                url2 = url5;
                i = 2;
                res = ((NiceResponse) $result).getDocument();
                elementSelectFirst = res.selectFirst("script:containsData(?go=)");
                if (elementSelectFirst != null) {
                    strSubstringAfter$default = StringsKt.substringAfter$default(strData, "?go=", (String) null, i, (Object) null);
                    if (strSubstringAfter$default != null) {
                        return null;
                    }
                    skToken = StringsKt.substringBefore$default(strSubstringAfter$default, "\"", (String) null, i, (Object) null);
                    if (skToken != null) {
                        Map mapMapOf4 = MapsKt.mapOf(TuplesKt.to(skToken, String.valueOf(map.get("_wp_http2"))));
                        c02704.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        c02704.L$1 = SpillingKt.nullOutSpilledVariable(host4);
                        c02704.L$2 = SpillingKt.nullOutSpilledVariable(res);
                        c02704.L$3 = SpillingKt.nullOutSpilledVariable(formUrl3);
                        c02704.L$4 = SpillingKt.nullOutSpilledVariable(map);
                        c02704.L$5 = SpillingKt.nullOutSpilledVariable(skToken);
                        c02704.label = 4;
                        C02701 c027015 = c02704;
                        host5 = host4;
                        map2 = map;
                        skToken2 = skToken;
                        res2 = res;
                        $result = Requests.get$default(MainActivityKt.getApp(), host4 + "?go=" + skToken, (Map) null, (String) null, (Map) null, mapMapOf4, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c027015, 4078, (Object) null);
                        c02705 = c027015;
                        if ($result == obj) {
                            return obj;
                        }
                        elementSelectFirst2 = ((NiceResponse) $result).getDocument().selectFirst("meta[http-equiv=refresh]");
                        if (elementSelectFirst2 != null) {
                            driveUrl = null;
                        } else {
                            driveUrl = null;
                        }
                        app = MainActivityKt.getApp();
                        if (driveUrl == null) {
                            return null;
                        }
                        c02705.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        c02705.L$1 = SpillingKt.nullOutSpilledVariable(host5);
                        c02705.L$2 = SpillingKt.nullOutSpilledVariable(res2);
                        c02705.L$3 = SpillingKt.nullOutSpilledVariable(formUrl3);
                        c02705.L$4 = SpillingKt.nullOutSpilledVariable(map2);
                        c02705.L$5 = SpillingKt.nullOutSpilledVariable(skToken2);
                        c02705.L$6 = driveUrl;
                        c02705.label = 5;
                        $result = Requests.get$default(app, driveUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02705, 4094, (Object) null);
                        if ($result == obj) {
                            return obj;
                        }
                        path = StringsKt.substringBefore$default(StringsKt.substringAfter$default(((NiceResponse) $result).getText(), "replace(\"", (String) null, i, (Object) null), "\")", (String) null, i, (Object) null);
                        if (Intrinsics.areEqual(path, "/404")) {
                            return null;
                        }
                        return fixUrl(path, getBaseUrl(driveUrl));
                    }
                }
                return null;
            case 4:
                String skToken3 = (String) c02701.L$5;
                Map<String, String> map4 = (Map) c02701.L$4;
                String formUrl7 = (String) c02701.L$3;
                Document res8 = (Document) c02701.L$2;
                String host9 = (String) c02701.L$1;
                String url6 = (String) c02701.L$0;
                ResultKt.throwOnFailure($result);
                skToken2 = skToken3;
                map2 = map4;
                formUrl3 = formUrl7;
                res2 = res8;
                host5 = host9;
                url2 = url6;
                i = 2;
                c02705 = c02701;
                obj = coroutine_suspended;
                elementSelectFirst2 = ((NiceResponse) $result).getDocument().selectFirst("meta[http-equiv=refresh]");
                if (elementSelectFirst2 != null) {
                    driveUrl = null;
                } else {
                    driveUrl = null;
                }
                app = MainActivityKt.getApp();
                if (driveUrl == null) {
                    return null;
                }
                c02705.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c02705.L$1 = SpillingKt.nullOutSpilledVariable(host5);
                c02705.L$2 = SpillingKt.nullOutSpilledVariable(res2);
                c02705.L$3 = SpillingKt.nullOutSpilledVariable(formUrl3);
                c02705.L$4 = SpillingKt.nullOutSpilledVariable(map2);
                c02705.L$5 = SpillingKt.nullOutSpilledVariable(skToken2);
                c02705.L$6 = driveUrl;
                c02705.label = 5;
                $result = Requests.get$default(app, driveUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02705, 4094, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                path = StringsKt.substringBefore$default(StringsKt.substringAfter$default(((NiceResponse) $result).getText(), "replace(\"", (String) null, i, (Object) null), "\")", (String) null, i, (Object) null);
                if (Intrinsics.areEqual(path, "/404")) {
                    return null;
                }
                return fixUrl(path, getBaseUrl(driveUrl));
            case 5:
                driveUrl = (String) c02701.L$6;
                ResultKt.throwOnFailure($result);
                i = 2;
                path = StringsKt.substringBefore$default(StringsKt.substringAfter$default(((NiceResponse) $result).getText(), "replace(\"", (String) null, i, (Object) null), "\")", (String) null, i, (Object) null);
                if (Intrinsics.areEqual(path, "/404")) {
                    return null;
                }
                return fixUrl(path, getBaseUrl(driveUrl));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private static final String bypassHrefli$getFormUrl(Document $this$bypassHrefli_u24getFormUrl) {
        return $this$bypassHrefli_u24getFormUrl.select("form#landing").attr("action");
    }

    private static final Map<String, String> bypassHrefli$getFormData(Document $this$bypassHrefli_u24getFormData) {
        Iterable $this$associate$iv = $this$bypassHrefli_u24getFormData.select("form#landing input");
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associate$iv) {
            Element it = (Element) element$iv$iv;
            Pair pair = TuplesKt.to(it.attr("name"), it.attr("value"));
            destination$iv$iv.put(pair.getFirst(), pair.getSecond());
        }
        return destination$iv$iv;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public static final Object convertTmdbToAnimeId(@Nullable String title, @Nullable String date, @Nullable String airedDate, @NotNull TvType type, @NotNull Continuation<? super AniIds> continuation) {
        C02731 c02731;
        Object objTmdbToAnimeId;
        String date2;
        List sDate;
        List sDate2;
        Integer year;
        Integer year2;
        String airedSeason;
        String airedSeason2;
        String season;
        String str;
        String str2;
        String str3;
        String str4;
        String title2 = title;
        TvType type2 = type;
        if (continuation instanceof C02731) {
            c02731 = (C02731) continuation;
            if ((c02731.label & Integer.MIN_VALUE) != 0) {
                c02731.label -= Integer.MIN_VALUE;
            } else {
                c02731 = new C02731(continuation);
            }
        } else {
            c02731 = new C02731(continuation);
        }
        Object $result = c02731.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c02731.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Integer intOrNull = null;
                List sDate3 = date != null ? StringsKt.split$default(date, new String[]{"-"}, false, 0, 6, (Object) null) : null;
                List sAiredDate = airedDate != null ? StringsKt.split$default(airedDate, new String[]{"-"}, false, 0, 6, (Object) null) : null;
                Integer year3 = (sDate3 == null || (str4 = (String) CollectionsKt.firstOrNull(sDate3)) == null) ? null : StringsKt.toIntOrNull(str4);
                Integer airedYear = (sAiredDate == null || (str3 = (String) CollectionsKt.firstOrNull(sAiredDate)) == null) ? null : StringsKt.toIntOrNull(str3);
                String season2 = getSeason((sDate3 == null || (str2 = (String) sDate3.get(1)) == null) ? null : StringsKt.toIntOrNull(str2));
                if (sAiredDate != null && (str = (String) sAiredDate.get(1)) != null) {
                    intOrNull = StringsKt.toIntOrNull(str);
                }
                String airedSeason3 = getSeason(intOrNull);
                if (type2 == TvType.AnimeMovie) {
                    c02731.L$0 = SpillingKt.nullOutSpilledVariable(title2);
                    c02731.L$1 = SpillingKt.nullOutSpilledVariable(date);
                    c02731.L$2 = SpillingKt.nullOutSpilledVariable(airedDate);
                    c02731.L$3 = SpillingKt.nullOutSpilledVariable(type2);
                    c02731.L$4 = SpillingKt.nullOutSpilledVariable(sDate3);
                    c02731.L$5 = SpillingKt.nullOutSpilledVariable(sAiredDate);
                    c02731.L$6 = SpillingKt.nullOutSpilledVariable(year3);
                    c02731.L$7 = SpillingKt.nullOutSpilledVariable(airedYear);
                    c02731.L$8 = SpillingKt.nullOutSpilledVariable(season2);
                    c02731.L$9 = SpillingKt.nullOutSpilledVariable(airedSeason3);
                    c02731.label = 1;
                    Object objTmdbToAnimeId2 = tmdbToAnimeId(title2, airedYear, "", type2, c02731);
                    return objTmdbToAnimeId2 == coroutine_suspended ? coroutine_suspended : objTmdbToAnimeId2;
                }
                c02731.L$0 = title2;
                c02731.L$1 = SpillingKt.nullOutSpilledVariable(date);
                c02731.L$2 = SpillingKt.nullOutSpilledVariable(airedDate);
                c02731.L$3 = type2;
                c02731.L$4 = SpillingKt.nullOutSpilledVariable(sDate3);
                c02731.L$5 = SpillingKt.nullOutSpilledVariable(sAiredDate);
                c02731.L$6 = SpillingKt.nullOutSpilledVariable(year3);
                c02731.L$7 = airedYear;
                c02731.L$8 = SpillingKt.nullOutSpilledVariable(season2);
                c02731.L$9 = airedSeason3;
                c02731.label = 2;
                objTmdbToAnimeId = tmdbToAnimeId(title2, year3, season2, type2, c02731);
                if (objTmdbToAnimeId == coroutine_suspended) {
                    return coroutine_suspended;
                }
                date2 = date;
                sDate = sDate3;
                sDate2 = sAiredDate;
                year = year3;
                year2 = airedYear;
                airedSeason = airedSeason3;
                airedSeason2 = season2;
                season = airedDate;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            case 2:
                airedSeason = (String) c02731.L$9;
                airedSeason2 = (String) c02731.L$8;
                year2 = (Integer) c02731.L$7;
                year = (Integer) c02731.L$6;
                sDate2 = (List) c02731.L$5;
                List sDate4 = (List) c02731.L$4;
                type2 = (TvType) c02731.L$3;
                season = (String) c02731.L$2;
                date2 = (String) c02731.L$1;
                title2 = (String) c02731.L$0;
                ResultKt.throwOnFailure($result);
                sDate = sDate4;
                objTmdbToAnimeId = $result;
                break;
            case 3:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AniIds ids = (AniIds) objTmdbToAnimeId;
        if (ids.getId() != null || ids.getIdMal() != null) {
            return ids;
        }
        c02731.L$0 = SpillingKt.nullOutSpilledVariable(title2);
        c02731.L$1 = SpillingKt.nullOutSpilledVariable(date2);
        c02731.L$2 = SpillingKt.nullOutSpilledVariable(season);
        c02731.L$3 = SpillingKt.nullOutSpilledVariable(type2);
        c02731.L$4 = SpillingKt.nullOutSpilledVariable(sDate);
        c02731.L$5 = SpillingKt.nullOutSpilledVariable(sDate2);
        c02731.L$6 = SpillingKt.nullOutSpilledVariable(year);
        c02731.L$7 = SpillingKt.nullOutSpilledVariable(year2);
        c02731.L$8 = SpillingKt.nullOutSpilledVariable(airedSeason2);
        c02731.L$9 = SpillingKt.nullOutSpilledVariable(airedSeason);
        c02731.L$10 = SpillingKt.nullOutSpilledVariable(ids);
        c02731.label = 3;
        Object objTmdbToAnimeId3 = tmdbToAnimeId(title2, year2, airedSeason, type2, c02731);
        return objTmdbToAnimeId3 == coroutine_suspended ? coroutine_suspended : objTmdbToAnimeId3;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Nullable
    public static final Object tmdbToAnimeId(@Nullable String title, @Nullable Integer year, @Nullable String season, @NotNull TvType type, @NotNull Continuation<? super AniIds> continuation) {
        C02931 c02931;
        boolean z;
        Object safe;
        AniData data;
        AniPage page;
        ArrayList<AniMedia> media;
        if (continuation instanceof C02931) {
            c02931 = (C02931) continuation;
            if ((c02931.label & Integer.MIN_VALUE) != 0) {
                c02931.label -= Integer.MIN_VALUE;
            } else {
                c02931 = new C02931(continuation);
            }
        } else {
            c02931 = new C02931(continuation);
        }
        C02931 c02932 = c02931;
        Object $result = c02932.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c02932.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String query = StringsKt.trim("query (\n  $page: Int = 1\n  $search: String\n  $sort: [MediaSort] = [POPULARITY_DESC, SCORE_DESC]\n  $type: MediaType\n  $seasonYear: Int\n  $format: [MediaFormat]\n) {\n  Page(page: $page, perPage: 20) {\n    media(\n      search: $search\n      sort: $sort\n      type: $type\n      seasonYear: $seasonYear\n      format_in: $format\n    ) {\n      id\n      idMal\n    }\n  }\n}").toString();
                Pair[] pairArr = new Pair[5];
                pairArr[0] = TuplesKt.to("search", title);
                pairArr[1] = TuplesKt.to("sort", "SEARCH_MATCH");
                pairArr[2] = TuplesKt.to("type", "ANIME");
                pairArr[3] = TuplesKt.to("seasonYear", year);
                pairArr[4] = TuplesKt.to("format", CollectionsKt.listOf(new String[]{type == TvType.AnimeMovie ? "MOVIE" : "TV", "ONA"}));
                Map $this$filterValues$iv = MapsKt.mapOf(pairArr);
                LinkedHashMap result$iv = new LinkedHashMap();
                for (Map.Entry entry$iv : $this$filterValues$iv.entrySet()) {
                    Object value = entry$iv.getValue();
                    if (value == null) {
                        z = false;
                    } else if (value.toString().length() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        result$iv.put(entry$iv.getKey(), entry$iv.getValue());
                    }
                }
                LinkedHashMap variables = result$iv;
                RequestBody data2 = RequestBody.Companion.create(AppUtils.INSTANCE.toJson(MapsKt.mapOf(new Pair[]{TuplesKt.to("query", query), TuplesKt.to("variables", variables)})), MediaType.Companion.parse("application/json;charset=utf-8"));
                Requests app = MainActivityKt.getApp();
                c02932.L$0 = SpillingKt.nullOutSpilledVariable(title);
                c02932.L$1 = SpillingKt.nullOutSpilledVariable(year);
                c02932.L$2 = SpillingKt.nullOutSpilledVariable(season);
                c02932.L$3 = SpillingKt.nullOutSpilledVariable(type);
                c02932.L$4 = SpillingKt.nullOutSpilledVariable(query);
                c02932.L$5 = SpillingKt.nullOutSpilledVariable(variables);
                c02932.L$6 = SpillingKt.nullOutSpilledVariable(data2);
                c02932.label = 1;
                $result = Requests.post$default(app, StreamPlay.anilistAPI, (Map) null, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, data2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02932, 65278, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) $result;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(AniSearch.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        AniSearch aniSearch = (AniSearch) safe;
        AniMedia res = (aniSearch == null || (data = aniSearch.getData()) == null || (page = data.getPage()) == null || (media = page.getMedia()) == null) ? null : (AniMedia) CollectionsKt.firstOrNull(media);
        return new AniIds(res != null ? res.getId() : null, res != null ? res.getIdMal() : null);
    }

    @NotNull
    public static final String generateWpKey(@NotNull String r, @NotNull String m) {
        Collection $this$toTypedArray$iv = StringsKt.split$default(r, new String[]{"\\x"}, false, 0, 6, (Object) null);
        String[] rList = (String[]) $this$toTypedArray$iv.toArray(new String[0]);
        String n = "";
        char[] charArray = MainAPIKt.base64Decode(CollectionsKt.joinToString$default(CollectionsKt.reversed(StringsKt.split$default(m, new String[]{""}, false, 0, 6, (Object) null)), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)).toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        String decodedM = new String(charArray);
        for (String s : StringsKt.split$default(decodedM, new String[]{"|"}, false, 0, 6, (Object) null)) {
            n = n + "\\x" + rList[Integer.parseInt(s) + 1];
        }
        return n;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Nullable
    public static final Object loadSourceNameExtractor(@NotNull String source, @NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull final Function1<? super ExtractorLink, Unit> function2, @Nullable final Integer quality, @NotNull String size, @NotNull Continuation<? super Unit> continuation) {
        C02871 c02871;
        if (continuation instanceof C02871) {
            c02871 = (C02871) continuation;
            if ((c02871.label & Integer.MIN_VALUE) != 0) {
                c02871.label -= Integer.MIN_VALUE;
            } else {
                c02871 = new C02871(continuation);
            }
        } else {
            c02871 = new C02871(continuation);
        }
        Object $result = c02871.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c02871.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final String provider = StringsKt.trim(source).toString();
                if (StringsKt.isBlank(provider)) {
                    provider = null;
                }
                String it = StringsKt.trim(size).toString();
                final String sizePart = StringsKt.isBlank(it) ? null : it;
                Function1 function3 = new Function1() { // from class: com.phisher98.StreamPlayUtilsKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        return StreamPlayUtilsKt.loadSourceNameExtractor$lambda$2(function2, provider, sizePart, quality, (ExtractorLink) obj);
                    }
                };
                c02871.L$0 = SpillingKt.nullOutSpilledVariable(source);
                c02871.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c02871.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c02871.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                c02871.L$4 = SpillingKt.nullOutSpilledVariable(function2);
                c02871.L$5 = SpillingKt.nullOutSpilledVariable(quality);
                c02871.L$6 = SpillingKt.nullOutSpilledVariable(size);
                c02871.L$7 = SpillingKt.nullOutSpilledVariable(provider);
                c02871.L$8 = SpillingKt.nullOutSpilledVariable(sizePart);
                c02871.label = 1;
                if (ExtractorApiKt.loadExtractor(url, referer, function1, function3, c02871) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object loadSourceNameExtractor$default(String str, String str2, String str3, Function1 function1, Function1 function2, Integer num, String str4, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 32) != 0) {
            num = null;
        }
        if ((i & 64) != 0) {
            str4 = "";
        }
        return loadSourceNameExtractor(str, str2, str3, function1, function2, num, str4, continuation);
    }

    static final Unit loadSourceNameExtractor$lambda$2(Function1 $callback, String $provider, String $sizePart, Integer $quality, ExtractorLink link) {
        BuildersKt.launch$default(extractorCallbackScope, (CoroutineContext) null, (CoroutineStart) null, new StreamPlayUtilsKt$loadSourceNameExtractor$2$1($callback, link, $provider, $sizePart, $quality, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public static final Object loadDisplaySourceNameExtractor(@Nullable final String sourceName, @Nullable final String displayName, @NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull final Function1<? super ExtractorLink, Unit> function2, @Nullable final Integer quality, @NotNull Continuation<? super Unit> continuation) {
        C02851 c02851;
        if (continuation instanceof C02851) {
            c02851 = (C02851) continuation;
            if ((c02851.label & Integer.MIN_VALUE) != 0) {
                c02851.label -= Integer.MIN_VALUE;
            } else {
                c02851 = new C02851(continuation);
            }
        } else {
            c02851 = new C02851(continuation);
        }
        Object $result = c02851.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c02851.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Function1 function3 = new Function1() { // from class: com.phisher98.StreamPlayUtilsKt$$ExternalSyntheticLambda8
                    public final Object invoke(Object obj) {
                        return StreamPlayUtilsKt.loadDisplaySourceNameExtractor$lambda$0(function2, sourceName, displayName, quality, (ExtractorLink) obj);
                    }
                };
                c02851.L$0 = SpillingKt.nullOutSpilledVariable(sourceName);
                c02851.L$1 = SpillingKt.nullOutSpilledVariable(displayName);
                c02851.L$2 = SpillingKt.nullOutSpilledVariable(url);
                c02851.L$3 = SpillingKt.nullOutSpilledVariable(referer);
                c02851.L$4 = SpillingKt.nullOutSpilledVariable(function1);
                c02851.L$5 = SpillingKt.nullOutSpilledVariable(function2);
                c02851.L$6 = SpillingKt.nullOutSpilledVariable(quality);
                c02851.label = 1;
                if (ExtractorApiKt.loadExtractor(url, referer, function1, function3, c02851) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object loadDisplaySourceNameExtractor$default(String str, String str2, String str3, String str4, Function1 function1, Function1 function2, Integer num, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            str4 = null;
        }
        if ((i & 64) != 0) {
            num = null;
        }
        return loadDisplaySourceNameExtractor(str, str2, str3, str4, function1, function2, num, continuation);
    }

    static final Unit loadDisplaySourceNameExtractor$lambda$0(Function1 $callback, String $sourceName, String $displayName, Integer $quality, ExtractorLink link) {
        BuildersKt.launch$default(extractorCallbackScope, (CoroutineContext) null, (CoroutineStart) null, new StreamPlayUtilsKt$loadDisplaySourceNameExtractor$2$1($callback, $sourceName, $displayName, link, $quality, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    @Nullable
    public static final String getSeason(@Nullable Integer month) {
        String[] seasons = {"Winter", "Winter", "Spring", "Spring", "Spring", "Summer", "Summer", "Summer", "Fall", "Fall", "Fall", "Winter"};
        if (month == null) {
            return null;
        }
        return seasons[month.intValue() - 1];
    }

    public static /* synthetic */ Pair getEpisodeSlug$default(Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        return getEpisodeSlug(num, num2);
    }

    @NotNull
    public static final Pair<String, String> getEpisodeSlug(@Nullable Integer season, @Nullable Integer episode) {
        if (season == null && episode == null) {
            return TuplesKt.to("", "");
        }
        Intrinsics.checkNotNull(season);
        String seasonSlug = season.intValue() < 10 ? new StringBuilder().append('0').append(season.intValue()).toString() : String.valueOf(season.intValue());
        Intrinsics.checkNotNull(episode);
        String episodeSlug = episode.intValue() < 10 ? new StringBuilder().append('0').append(episode.intValue()).toString() : String.valueOf(episode.intValue());
        return TuplesKt.to(seasonSlug, episodeSlug);
    }

    @Nullable
    public static final String createSlug(@Nullable String $this$createSlug) throws IOException {
        String string;
        if ($this$createSlug != null) {
            String $this$filterTo$iv$iv = $this$createSlug;
            Appendable destination$iv$iv = new StringBuilder();
            int length = $this$filterTo$iv$iv.length();
            for (int index$iv$iv = 0; index$iv$iv < length; index$iv$iv++) {
                char element$iv$iv = $this$filterTo$iv$iv.charAt(index$iv$iv);
                if (CharsKt.isWhitespace(element$iv$iv) || Character.isLetterOrDigit(element$iv$iv)) {
                    destination$iv$iv.append(element$iv$iv);
                }
            }
            String $this$filter$iv = ((StringBuilder) destination$iv$iv).toString();
            if ($this$filter$iv != null && (string = StringsKt.trim($this$filter$iv).toString()) != null) {
                String strReplace = new Regex("\\s+").replace(string, "-");
                if (strReplace != null) {
                    String lowerCase = strReplace.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    return lowerCase;
                }
            }
        }
        return null;
    }

    @Nullable
    public static final String getKisskhTitle(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return new Regex("[^a-zA-Z\\d]").replace(str, "-");
    }

    public static /* synthetic */ String getIndexQualityTags$default(String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return getIndexQualityTags(str, z);
    }

    @NotNull
    public static final String getIndexQualityTags(@Nullable String str, boolean fullTag) {
        List groupValues;
        String str2;
        String strReplace$default;
        String string;
        List groupValues2;
        String str3;
        String string2;
        if (fullTag) {
            MatchResult matchResultFind$default = Regex.find$default(new Regex("(?i)(.*)\\.(?:mkv|mp4|avi)"), str == null ? "" : str, 0, 2, (Object) null);
            if (matchResultFind$default != null && (groupValues2 = matchResultFind$default.getGroupValues()) != null && (str3 = (String) groupValues2.get(1)) != null && (string2 = StringsKt.trim(str3).toString()) != null) {
                return string2;
            }
            if (str == null) {
                return "";
            }
        } else {
            MatchResult matchResultFind$default2 = Regex.find$default(new Regex("(?i)\\d{3,4}[pP]\\.?(.*?)\\.(mkv|mp4|avi)"), str == null ? "" : str, 0, 2, (Object) null);
            if (matchResultFind$default2 != null && (groupValues = matchResultFind$default2.getGroupValues()) != null && (str2 = (String) CollectionsKt.getOrNull(groupValues, 1)) != null && (strReplace$default = StringsKt.replace$default(str2, ".", " ", false, 4, (Object) null)) != null && (string = StringsKt.trim(strReplace$default).toString()) != null) {
                return string;
            }
            if (str == null) {
                return "";
            }
        }
        return str;
    }

    public static final int getIndexQuality(@Nullable String str) {
        List groupValues;
        String str2;
        Integer intOrNull;
        MatchResult matchResultFind$default = Regex.find$default(new Regex("\\b(2160|1440|1080|720|576|540|480)\\s*[pP]\\b"), str == null ? "" : str, 0, 2, (Object) null);
        return (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str2 = (String) CollectionsKt.getOrNull(groupValues, 1)) == null || (intOrNull = StringsKt.toIntOrNull(str2)) == null) ? Qualities.Unknown.getValue() : intOrNull.intValue();
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00bf A[Catch: Exception -> 0x00f3, TryCatch #2 {Exception -> 0x00f3, blocks: (B:24:0x009a, B:25:0x00b9, B:27:0x00bf, B:33:0x00e4, B:35:0x00eb), top: B:49:0x009a }] */
    /* JADX WARN: Code duplicated, block: B:29:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:30:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:33:0x00e4 A[Catch: Exception -> 0x00f3, TryCatch #2 {Exception -> 0x00f3, blocks: (B:24:0x009a, B:25:0x00b9, B:27:0x00bf, B:33:0x00e4, B:35:0x00eb), top: B:49:0x009a }] */
    /* JADX WARN: Code duplicated, block: B:55:0x00e8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Nullable
    public static final Object extractMdrive(@NotNull String url, @NotNull Continuation<? super List<String>> continuation) {
        C02741 c02741;
        Regex regex;
        Iterable $this$mapNotNull$iv;
        Collection destination$iv$iv;
        String href;
        String str;
        if (continuation instanceof C02741) {
            c02741 = (C02741) continuation;
            if ((c02741.label & Integer.MIN_VALUE) != 0) {
                c02741.label -= Integer.MIN_VALUE;
            } else {
                c02741 = new C02741(continuation);
            }
        } else {
            c02741 = new C02741(continuation);
        }
        C02741 c02742 = c02741;
        Object $result = c02742.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c02742.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Regex regex2 = new Regex("hubcloud|gdflix|gdlink", RegexOption.IGNORE_CASE);
                try {
                    Requests app = MainActivityKt.getApp();
                    c02742.L$0 = SpillingKt.nullOutSpilledVariable(url);
                    c02742.L$1 = regex2;
                    c02742.label = 1;
                    try {
                        Object obj = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02742, 4094, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = obj;
                        regex = regex2;
                        try {
                            $this$mapNotNull$iv = ((NiceResponse) $result).getDocument().select("a[href]");
                            destination$iv$iv = new ArrayList();
                            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                Element element = (Element) element$iv$iv$iv;
                                Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                                href = element.attr("href");
                                if (regex.containsMatchIn(href)) {
                                    str = null;
                                }
                                if (str != null) {
                                    str = href;
                                    destination$iv$iv.add(str);
                                } else {
                                    str = href;
                                }
                                $this$mapNotNull$iv = $this$mapNotNull$iv2;
                            }
                            return (List) destination$iv$iv;
                        } catch (Exception e) {
                            e = e;
                            Log.INSTANCE.e("Error Mdrive", "Error extracting links: " + e.getLocalizedMessage());
                            return CollectionsKt.emptyList();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        Log.INSTANCE.e("Error Mdrive", "Error extracting links: " + e.getLocalizedMessage());
                        return CollectionsKt.emptyList();
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                break;
            case 1:
                regex = (Regex) c02742.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    $this$mapNotNull$iv = ((NiceResponse) $result).getDocument().select("a[href]");
                    destination$iv$iv = new ArrayList();
                    while (r10.hasNext()) {
                        Element element2 = (Element) element$iv$iv$iv;
                        Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                        href = element2.attr("href");
                        if (regex.containsMatchIn(href)) {
                            str = null;
                        }
                        if (str != null) {
                            str = href;
                            destination$iv$iv.add(str);
                        } else {
                            str = href;
                        }
                        $this$mapNotNull$iv = $this$mapNotNull$iv3;
                    }
                    return (List) destination$iv$iv;
                } catch (Exception e4) {
                    e = e4;
                    Log.INSTANCE.e("Error Mdrive", "Error extracting links: " + e.getLocalizedMessage());
                    return CollectionsKt.emptyList();
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @NotNull
    public static final String getBaseUrl(@NotNull String url) {
        URI it = new URI(url);
        return it.getScheme() + "://" + it.getHost();
    }

    @NotNull
    public static final String getHost(@NotNull String $this$getHost) {
        return MainAPIKt.fixTitle(StringsKt.substringAfterLast$default(StringsKt.substringBeforeLast$default(new URI($this$getHost).getHost(), ".", (String) null, 2, (Object) null), ".", (String) null, 2, (Object) null));
    }

    public static final boolean isUpcoming(@Nullable String dateString) {
        try {
            SimpleDateFormat format = getTmdbDateFormatter();
            if (dateString != null) {
                Date date = format.parse(dateString);
                Long lValueOf = date != null ? Long.valueOf(date.getTime()) : null;
                if (lValueOf != null) {
                    long dateTime = lValueOf.longValue();
                    return APIHolder.INSTANCE.getUnixTimeMS() < dateTime;
                }
            }
            return false;
        } catch (Throwable t) {
            ArchComponentExtKt.logError(t);
            return false;
        }
    }

    @NotNull
    public static final TmdbDate getDate() {
        SimpleDateFormat formatter = getTmdbDateFormatter();
        Calendar calendar = Calendar.getInstance();
        String today = formatter.format(calendar.getTime());
        calendar.add(3, 1);
        String nextWeek = formatter.format(calendar.getTime());
        calendar.setTime(new Date());
        calendar.set(7, 2);
        calendar.add(3, -1);
        String lastWeekStart = formatter.format(calendar.getTime());
        calendar.setTime(new Date());
        calendar.set(5, 1);
        String monthStart = formatter.format(calendar.getTime());
        return new TmdbDate(today, nextWeek, lastWeekStart, monthStart);
    }

    @NotNull
    public static final String fixUrl(@NotNull String url, @NotNull String domain) {
        if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null)) {
            return url;
        }
        if (url.length() == 0) {
            return "";
        }
        boolean startsWithNoHttp = StringsKt.startsWith$default(url, "//", false, 2, (Object) null);
        if (startsWithNoHttp) {
            return "https:" + url;
        }
        if (StringsKt.startsWith$default(url, '/', false, 2, (Object) null)) {
            return domain + url;
        }
        return domain + '/' + url;
    }

    @NotNull
    public static final String toRomanNumeral(int $this$toRomanNumeral) {
        Symbol symbol = Symbol.INSTANCE.closestBelow($this$toRomanNumeral);
        if (symbol != null) {
            return symbol + toRomanNumeral($this$toRomanNumeral - symbol.getDecimalValue());
        }
        return "";
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0545  */
    /* JADX WARN: Code duplicated, block: B:107:0x0548  */
    /* JADX WARN: Code duplicated, block: B:109:0x05c4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:110:0x05c5  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Code duplicated, block: B:99:0x04f7  */
    @Nullable
    public static final Object invokeExternalSource(@Nullable Integer mediaId, @Nullable Integer type, @Nullable Integer season, @Nullable Integer episode, @NotNull Function1<? super ExtractorLink, Unit> function1, @Nullable String token, @NotNull Continuation<? super Unit> continuation) {
        C02821 c02821;
        Object obj;
        String str;
        String token2;
        String fourthAPI;
        Object obj2;
        Map headers;
        String thirdAPI;
        String fourthAPI2;
        String seasonSlug;
        Integer mediaId2;
        Integer type2;
        Integer season2;
        Integer episode2;
        Function1<? super ExtractorLink, Unit> function2;
        Object safe;
        ER er;
        DData data;
        String link;
        String shareKey;
        ArrayList arrayList;
        Integer season3;
        String str2;
        String episodeSlug;
        Map headers2;
        String seasonSlug2;
        String token3;
        Function1<? super ExtractorLink, Unit> function3;
        String fourthAPI3;
        String thirdAPI2;
        Object safe2;
        ExternalResponse externalResponse;
        ExternalResponse.Data shareRes;
        ExternalResponse.Data shareRes2;
        ExternalResponse.Data shareRes3;
        Integer mediaId3;
        String episodeSlug2;
        Integer episode3;
        String fourthAPI4;
        List<ExternalResponse.Data.FileList> fileList;
        Integer season4;
        String shareKey2;
        String seasonSlug3;
        String thirdAPI3;
        Object next;
        Long fid;
        ExternalResponse.Data shareRes4;
        Map headers3;
        String fourthAPI5;
        String token4;
        Function1<? super ExtractorLink, Unit> function4;
        String seasonSlug4;
        C02832 c02832;
        Object safe3;
        ExternalResponse externalResponse2;
        ExternalResponse.Data shareRes5;
        Function1<? super ExtractorLink, Unit> function5;
        ExternalResponse.Data data2;
        Iterable fileList2;
        int $i$f$filter;
        ExternalResponse.Data shareRes6;
        Function1<? super ExtractorLink, Unit> function6;
        if (continuation instanceof C02821) {
            c02821 = (C02821) continuation;
            if ((c02821.label & Integer.MIN_VALUE) != 0) {
                c02821.label -= Integer.MIN_VALUE;
            } else {
                c02821 = new C02821(continuation);
            }
        } else {
            c02821 = new C02821(continuation);
        }
        C02821 c02822 = c02821;
        Object $result = c02822.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c02822.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Pair<String, String> episodeSlug3 = getEpisodeSlug(season, episode);
                String seasonSlug5 = (String) episodeSlug3.component1();
                String episodeSlug4 = (String) episodeSlug3.component2();
                Map headers4 = MapsKt.mapOf(TuplesKt.to("Accept-Language", "en"));
                Requests app = MainActivityKt.getApp();
                String str3 = StreamPlay.fourthAPI + "/index/share_link?id=" + mediaId + "&type=" + type;
                c02822.L$0 = SpillingKt.nullOutSpilledVariable(mediaId);
                c02822.L$1 = SpillingKt.nullOutSpilledVariable(type);
                c02822.L$2 = season;
                c02822.L$3 = SpillingKt.nullOutSpilledVariable(episode);
                c02822.L$4 = function1;
                c02822.L$5 = token;
                c02822.L$6 = StreamPlay.thrirdAPI;
                c02822.L$7 = SpillingKt.nullOutSpilledVariable(StreamPlay.fourthAPI);
                c02822.L$8 = seasonSlug5;
                c02822.L$9 = episodeSlug4;
                c02822.L$10 = headers4;
                c02822.label = 1;
                obj = coroutine_suspended;
                str = "/file/file_share_list?share_key=";
                Object obj3 = Requests.get$default(app, str3, headers4, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02822, 4092, (Object) null);
                c02822 = c02822;
                if (obj3 == obj) {
                    return obj;
                }
                token2 = token;
                fourthAPI = StreamPlay.fourthAPI;
                obj2 = obj3;
                headers = headers4;
                thirdAPI = StreamPlay.thrirdAPI;
                fourthAPI2 = seasonSlug5;
                seasonSlug = episodeSlug4;
                mediaId2 = mediaId;
                type2 = type;
                season2 = season;
                episode2 = episode;
                function2 = function1;
                NiceResponse this_$iv = (NiceResponse) obj2;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(ER.class));
                    break;
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                er = (ER) safe;
                if (er != null || (data = er.getData()) == null || (link = data.getLink()) == null || (shareKey = StringsKt.substringAfterLast$default(link, "/", (String) null, 2, (Object) null)) == null) {
                    return Unit.INSTANCE;
                }
                String str4 = str;
                c02822.L$0 = SpillingKt.nullOutSpilledVariable(mediaId2);
                c02822.L$1 = SpillingKt.nullOutSpilledVariable(type2);
                c02822.L$2 = season2;
                c02822.L$3 = SpillingKt.nullOutSpilledVariable(episode2);
                c02822.L$4 = function2;
                c02822.L$5 = token2;
                c02822.L$6 = thirdAPI;
                c02822.L$7 = SpillingKt.nullOutSpilledVariable(fourthAPI);
                c02822.L$8 = fourthAPI2;
                c02822.L$9 = seasonSlug;
                c02822.L$10 = headers;
                c02822.L$11 = shareKey;
                c02822.label = 2;
                String token5 = token2;
                Function1<? super ExtractorLink, Unit> function7 = function2;
                Map headers5 = headers;
                String episodeSlug5 = seasonSlug;
                String seasonSlug6 = fourthAPI2;
                String thirdAPI4 = thirdAPI;
                C02821 c02823 = c02822;
                arrayList = null;
                season3 = season2;
                str2 = str4;
                $result = Requests.get$default(MainActivityKt.getApp(), thirdAPI + str4 + shareKey, headers5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02823, 4092, (Object) null);
                c02822 = c02823;
                if ($result == obj) {
                    return obj;
                }
                episodeSlug = shareKey;
                headers2 = headers5;
                seasonSlug2 = episodeSlug5;
                token3 = token5;
                function3 = function7;
                fourthAPI3 = seasonSlug6;
                thirdAPI2 = thirdAPI4;
                NiceResponse this_$iv2 = (NiceResponse) $result;
                try {
                    ResponseParser parser2 = this_$iv2.getParser();
                    Intrinsics.checkNotNull(parser2);
                    safe2 = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(ExternalResponse.class));
                    break;
                } catch (Exception e$iv2) {
                    e$iv2.printStackTrace();
                    safe2 = arrayList;
                }
                externalResponse = (ExternalResponse) safe2;
                if (externalResponse != null || (shareRes = externalResponse.getData()) == null) {
                    return Unit.INSTANCE;
                }
                if (season3 == null) {
                    episodeSlug2 = seasonSlug2;
                    seasonSlug3 = fourthAPI3;
                    thirdAPI3 = thirdAPI2;
                    episode3 = episode2;
                    fourthAPI4 = fourthAPI;
                    season4 = season3;
                    shareKey2 = episodeSlug;
                    fileList = shareRes.getFileList();
                    shareRes3 = shareRes;
                    mediaId3 = mediaId2;
                } else {
                    List<ExternalResponse.Data.FileList> fileList3 = shareRes.getFileList();
                    if (fileList3 != null) {
                        Iterator<T> it = fileList3.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                next = it.next();
                                ExternalResponse.Data.FileList it2 = (ExternalResponse.Data.FileList) next;
                                shareRes2 = shareRes;
                                if (!StringsKt.equals(it2.getFileName(), "season " + season3.intValue(), true)) {
                                    shareRes = shareRes2;
                                }
                            } else {
                                shareRes2 = shareRes;
                                next = arrayList;
                            }
                        }
                        ExternalResponse.Data.FileList fileList4 = (ExternalResponse.Data.FileList) next;
                        if (fileList4 != null && (fid = fileList4.getFid()) != null) {
                            long parentId = fid.longValue();
                            c02822.L$0 = SpillingKt.nullOutSpilledVariable(mediaId2);
                            c02822.L$1 = SpillingKt.nullOutSpilledVariable(type2);
                            c02822.L$2 = SpillingKt.nullOutSpilledVariable(season3);
                            c02822.L$3 = SpillingKt.nullOutSpilledVariable(episode2);
                            c02822.L$4 = function3;
                            c02822.L$5 = token3;
                            c02822.L$6 = thirdAPI2;
                            c02822.L$7 = SpillingKt.nullOutSpilledVariable(fourthAPI);
                            c02822.L$8 = fourthAPI3;
                            c02822.L$9 = seasonSlug2;
                            c02822.L$10 = SpillingKt.nullOutSpilledVariable(headers2);
                            c02822.L$11 = episodeSlug;
                            c02822.L$12 = SpillingKt.nullOutSpilledVariable(shareRes2);
                            c02822.J$0 = parentId;
                            c02822.label = 3;
                            String token6 = token3;
                            Function1<? super ExtractorLink, Unit> function8 = function3;
                            Map headers6 = headers2;
                            String shareKey3 = episodeSlug;
                            String episodeSlug6 = seasonSlug2;
                            String seasonSlug7 = fourthAPI3;
                            String thirdAPI5 = thirdAPI2;
                            C02821 c02824 = c02822;
                            $result = Requests.get$default(MainActivityKt.getApp(), thirdAPI2 + str2 + episodeSlug + "&parent_id=" + parentId + "&page=1", headers6, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02824, 4092, (Object) null);
                            c02822 = c02824;
                            if ($result == obj) {
                                return obj;
                            }
                            shareRes4 = shareRes2;
                            headers3 = headers6;
                            episodeSlug2 = episodeSlug6;
                            fourthAPI5 = fourthAPI;
                            token4 = token6;
                            shareKey2 = shareKey3;
                            function4 = function8;
                            seasonSlug4 = seasonSlug7;
                            thirdAPI3 = thirdAPI5;
                            NiceResponse this_$iv3 = (NiceResponse) $result;
                            try {
                                ResponseParser parser3 = this_$iv3.getParser();
                                Intrinsics.checkNotNull(parser3);
                                try {
                                    try {
                                        safe3 = parser3.parseSafe(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(ExternalResponse.class));
                                    } catch (Exception e) {
                                        e$iv = e;
                                        e$iv.printStackTrace();
                                        safe3 = arrayList;
                                    }
                                } catch (Exception e2) {
                                    e$iv = e2;
                                }
                            } catch (Exception e3) {
                                e$iv = e3;
                            }
                            externalResponse2 = (ExternalResponse) safe3;
                            if (externalResponse2 != null || (data2 = externalResponse2.getData()) == null || (fileList2 = data2.getFileList()) == null) {
                                shareRes5 = shareRes4;
                                function5 = function4;
                            } else {
                                Iterable $this$filter$iv = fileList2;
                                int $i$f$filter2 = 0;
                                Collection destination$iv$iv = new ArrayList();
                                for (Object element$iv$iv : $this$filter$iv) {
                                    Iterable $this$filter$iv2 = $this$filter$iv;
                                    ExternalResponse.Data.FileList it3 = (ExternalResponse.Data.FileList) element$iv$iv;
                                    String fileName = it3.getFileName();
                                    boolean z = false;
                                    if (fileName != null) {
                                        $i$f$filter = $i$f$filter2;
                                        shareRes6 = shareRes4;
                                        function6 = function4;
                                        if (StringsKt.contains(fileName, 's' + seasonSlug4 + 'e' + episodeSlug2, true)) {
                                            z = true;
                                        }
                                    } else {
                                        $i$f$filter = $i$f$filter2;
                                        shareRes6 = shareRes4;
                                        function6 = function4;
                                    }
                                    if (z) {
                                        destination$iv$iv.add(element$iv$iv);
                                    }
                                    $this$filter$iv = $this$filter$iv2;
                                    $i$f$filter2 = $i$f$filter;
                                    shareRes4 = shareRes6;
                                    function4 = function6;
                                }
                                shareRes5 = shareRes4;
                                function5 = function4;
                                arrayList = (List) destination$iv$iv;
                            }
                            shareRes3 = shareRes5;
                            function3 = function5;
                            token3 = token4;
                            headers2 = headers3;
                            seasonSlug3 = seasonSlug4;
                            fourthAPI4 = fourthAPI5;
                            mediaId3 = mediaId2;
                            episode3 = episode2;
                            fileList = arrayList;
                            season4 = season3;
                            break;
                        }
                    } else {
                        shareRes2 = shareRes;
                    }
                    shareRes3 = shareRes2;
                    headers2 = headers2;
                    mediaId3 = mediaId2;
                    episodeSlug2 = seasonSlug2;
                    episode3 = episode2;
                    fourthAPI4 = fourthAPI;
                    token3 = token3;
                    fileList = arrayList;
                    season4 = season3;
                    shareKey2 = episodeSlug;
                    function3 = function3;
                    seasonSlug3 = fourthAPI3;
                    thirdAPI3 = thirdAPI2;
                }
                if (fileList == null) {
                    return Unit.INSTANCE;
                }
                Function1<? super ExtractorLink, Unit> function9 = function3;
                String token7 = token3;
                String shareKey4 = shareKey2;
                String thirdAPI6 = thirdAPI3;
                c02832 = new C02832(token7, thirdAPI6, shareKey4, function9, null);
                c02822.L$0 = SpillingKt.nullOutSpilledVariable(mediaId3);
                c02822.L$1 = SpillingKt.nullOutSpilledVariable(type2);
                c02822.L$2 = SpillingKt.nullOutSpilledVariable(season4);
                c02822.L$3 = SpillingKt.nullOutSpilledVariable(episode3);
                c02822.L$4 = SpillingKt.nullOutSpilledVariable(function9);
                c02822.L$5 = SpillingKt.nullOutSpilledVariable(token7);
                c02822.L$6 = SpillingKt.nullOutSpilledVariable(thirdAPI6);
                c02822.L$7 = SpillingKt.nullOutSpilledVariable(fourthAPI4);
                c02822.L$8 = SpillingKt.nullOutSpilledVariable(seasonSlug3);
                c02822.L$9 = SpillingKt.nullOutSpilledVariable(episodeSlug2);
                c02822.L$10 = SpillingKt.nullOutSpilledVariable(headers2);
                c02822.L$11 = SpillingKt.nullOutSpilledVariable(shareKey4);
                c02822.L$12 = SpillingKt.nullOutSpilledVariable(shareRes3);
                c02822.L$13 = SpillingKt.nullOutSpilledVariable(fileList);
                c02822.label = 4;
                if (ParCollectionsKt.amapIndexed(fileList, c02832, c02822) == obj) {
                    return obj;
                }
                return Unit.INSTANCE;
            case 1:
                Map headers7 = (Map) c02822.L$10;
                String episodeSlug7 = (String) c02822.L$9;
                String seasonSlug8 = (String) c02822.L$8;
                String fourthAPI6 = (String) c02822.L$7;
                thirdAPI = (String) c02822.L$6;
                String token8 = (String) c02822.L$5;
                Function1<? super ExtractorLink, Unit> function10 = (Function1) c02822.L$4;
                Integer episode4 = (Integer) c02822.L$3;
                Integer season5 = (Integer) c02822.L$2;
                Integer type3 = (Integer) c02822.L$1;
                Integer mediaId4 = (Integer) c02822.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                str = "/file/file_share_list?share_key=";
                fourthAPI = fourthAPI6;
                token2 = token8;
                function2 = function10;
                episode2 = episode4;
                type2 = type3;
                mediaId2 = mediaId4;
                fourthAPI2 = seasonSlug8;
                season2 = season5;
                seasonSlug = episodeSlug7;
                headers = headers7;
                obj2 = $result;
                NiceResponse this_$iv4 = (NiceResponse) obj2;
                ResponseParser parser4 = this_$iv4.getParser();
                Intrinsics.checkNotNull(parser4);
                safe = parser4.parseSafe(this_$iv4.getText(), Reflection.getOrCreateKotlinClass(ER.class));
                er = (ER) safe;
                if (er != null) {
                }
                return Unit.INSTANCE;
            case 2:
                String shareKey5 = (String) c02822.L$11;
                headers2 = (Map) c02822.L$10;
                String episodeSlug8 = (String) c02822.L$9;
                String seasonSlug9 = (String) c02822.L$8;
                String fourthAPI7 = (String) c02822.L$7;
                thirdAPI2 = (String) c02822.L$6;
                String token9 = (String) c02822.L$5;
                Function1<? super ExtractorLink, Unit> function11 = (Function1) c02822.L$4;
                Integer episode5 = (Integer) c02822.L$3;
                Integer season6 = (Integer) c02822.L$2;
                Integer type4 = (Integer) c02822.L$1;
                Integer mediaId5 = (Integer) c02822.L$0;
                ResultKt.throwOnFailure($result);
                mediaId2 = mediaId5;
                obj = coroutine_suspended;
                str2 = "/file/file_share_list?share_key=";
                fourthAPI = fourthAPI7;
                token3 = token9;
                function3 = function11;
                episode2 = episode5;
                season3 = season6;
                type2 = type4;
                arrayList = null;
                fourthAPI3 = seasonSlug9;
                seasonSlug2 = episodeSlug8;
                episodeSlug = shareKey5;
                NiceResponse this_$iv5 = (NiceResponse) $result;
                ResponseParser parser5 = this_$iv5.getParser();
                Intrinsics.checkNotNull(parser5);
                safe2 = parser5.parseSafe(this_$iv5.getText(), Reflection.getOrCreateKotlinClass(ExternalResponse.class));
                externalResponse = (ExternalResponse) safe2;
                if (externalResponse != null) {
                }
                return Unit.INSTANCE;
            case 3:
                long j = c02822.J$0;
                shareRes4 = (ExternalResponse.Data) c02822.L$12;
                shareKey2 = (String) c02822.L$11;
                headers3 = (Map) c02822.L$10;
                episodeSlug2 = (String) c02822.L$9;
                seasonSlug4 = (String) c02822.L$8;
                fourthAPI5 = (String) c02822.L$7;
                thirdAPI3 = (String) c02822.L$6;
                token4 = (String) c02822.L$5;
                function4 = (Function1) c02822.L$4;
                Integer episode6 = (Integer) c02822.L$3;
                Integer season7 = (Integer) c02822.L$2;
                Integer type5 = (Integer) c02822.L$1;
                Integer mediaId6 = (Integer) c02822.L$0;
                ResultKt.throwOnFailure($result);
                type2 = type5;
                season3 = season7;
                episode2 = episode6;
                mediaId2 = mediaId6;
                obj = coroutine_suspended;
                arrayList = null;
                NiceResponse this_$iv6 = (NiceResponse) $result;
                ResponseParser parser6 = this_$iv6.getParser();
                Intrinsics.checkNotNull(parser6);
                safe3 = parser6.parseSafe(this_$iv6.getText(), Reflection.getOrCreateKotlinClass(ExternalResponse.class));
                externalResponse2 = (ExternalResponse) safe3;
                if (externalResponse2 != null) {
                    shareRes5 = shareRes4;
                    function5 = function4;
                } else {
                    shareRes5 = shareRes4;
                    function5 = function4;
                }
                shareRes3 = shareRes5;
                function3 = function5;
                token3 = token4;
                headers2 = headers3;
                seasonSlug3 = seasonSlug4;
                fourthAPI4 = fourthAPI5;
                mediaId3 = mediaId2;
                episode3 = episode2;
                fileList = arrayList;
                season4 = season3;
                if (fileList == null) {
                    return Unit.INSTANCE;
                }
                Function1<? super ExtractorLink, Unit> function12 = function3;
                String token10 = token3;
                String shareKey6 = shareKey2;
                String thirdAPI7 = thirdAPI3;
                c02832 = new C02832(token10, thirdAPI7, shareKey6, function12, null);
                c02822.L$0 = SpillingKt.nullOutSpilledVariable(mediaId3);
                c02822.L$1 = SpillingKt.nullOutSpilledVariable(type2);
                c02822.L$2 = SpillingKt.nullOutSpilledVariable(season4);
                c02822.L$3 = SpillingKt.nullOutSpilledVariable(episode3);
                c02822.L$4 = SpillingKt.nullOutSpilledVariable(function12);
                c02822.L$5 = SpillingKt.nullOutSpilledVariable(token10);
                c02822.L$6 = SpillingKt.nullOutSpilledVariable(thirdAPI7);
                c02822.L$7 = SpillingKt.nullOutSpilledVariable(fourthAPI4);
                c02822.L$8 = SpillingKt.nullOutSpilledVariable(seasonSlug3);
                c02822.L$9 = SpillingKt.nullOutSpilledVariable(episodeSlug2);
                c02822.L$10 = SpillingKt.nullOutSpilledVariable(headers2);
                c02822.L$11 = SpillingKt.nullOutSpilledVariable(shareKey6);
                c02822.L$12 = SpillingKt.nullOutSpilledVariable(shareRes3);
                c02822.L$13 = SpillingKt.nullOutSpilledVariable(fileList);
                c02822.label = 4;
                if (ParCollectionsKt.amapIndexed(fileList, c02832, c02822) == obj) {
                    return obj;
                }
                return Unit.INSTANCE;
            case 4:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ Object invokeExternalSource$default(Integer num, Integer num2, Integer num3, Integer num4, Function1 function1, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            num3 = null;
        }
        if ((i & 8) != 0) {
            num4 = null;
        }
        if ((i & 32) != 0) {
            str = null;
        }
        return invokeExternalSource(num, num2, num3, num4, function1, str, continuation);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayUtilsKt$invokeExternalSource$2 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "index", "", "fileList", "Lcom/phisher98/ExternalResponse$Data$FileList;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayUtilsKt$invokeExternalSource$2", f = "StreamPlayUtils.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {598, 648}, m = "invokeSuspend", n = {"fileList", "superToken", "index", "fileList", "superToken", "player", "json", "htmlContent", "document", "sourcesWithQualities", "sourcesJsonArray", "jsonObject", "$this$forEach$iv", "element$iv", "it", "element$iv", "source", "format", "label", "$this$forEach$iv", "parsedSources", "index"}, nl = {601, 647}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$12", "L$13", "L$15", "L$16", "L$17", "L$18", "L$20", "L$21", "I$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$invokeExternalSource$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,2265:1\n2068#2:2266\n2069#2:2268\n2068#2,2:2269\n2068#2:2271\n2068#2,2:2295\n2069#2:2297\n1#3:2267\n1#3:2275\n93#4,2:2272\n63#4:2274\n64#4,15:2276\n95#4,2:2293\n50#5:2291\n43#5:2292\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$invokeExternalSource$2\n*L\n614#1:2266\n614#1:2268\n629#1:2269,2\n639#1:2271\n641#1:2295,2\n639#1:2297\n640#1:2275\n640#1:2272,2\n640#1:2274\n640#1:2276,15\n640#1:2293,2\n640#1:2291\n640#1:2292\n*E\n"})
    static final class C02832 extends SuspendLambda implements Function3<Integer, ExternalResponse.Data.FileList, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $shareKey;
        final /* synthetic */ String $thirdAPI;
        final /* synthetic */ String $token;
        /* synthetic */ int I$0;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$19;
        Object L$2;
        Object L$20;
        Object L$21;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02832(String str, String str2, String str3, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C02832> continuation) {
            super(3, continuation);
            this.$token = str;
            this.$thirdAPI = str2;
            this.$shareKey = str3;
            this.$callback = function1;
        }

        public final Object invoke(int i, ExternalResponse.Data.FileList fileList, Continuation<? super Unit> continuation) {
            C02832 c02832 = new C02832(this.$token, this.$thirdAPI, this.$shareKey, this.$callback, continuation);
            c02832.I$0 = i;
            c02832.L$0 = fileList;
            return c02832.invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke(((Number) obj).intValue(), (ExternalResponse.Data.FileList) obj2, (Continuation<? super Unit>) obj3);
        }

        /* JADX WARN: Code duplicated, block: B:137:0x041e  */
        /* JADX WARN: Code duplicated, block: B:139:0x0436  */
        /* JADX WARN: Code duplicated, block: B:140:0x0439  */
        /* JADX WARN: Code duplicated, block: B:143:0x0445  */
        /* JADX WARN: Code duplicated, block: B:144:0x0448  */
        /* JADX WARN: Code duplicated, block: B:147:0x045a  */
        /* JADX WARN: Code duplicated, block: B:151:0x0464  */
        /* JADX WARN: Code duplicated, block: B:153:0x0490  */
        /* JADX WARN: Code duplicated, block: B:161:0x055b A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:164:0x0570  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:134:0x03ff -> B:135:0x0418). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:159:0x0534 -> B:160:0x0548). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:162:0x0560 -> B:163:0x0566). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:137:0x041e
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        public final java.lang.Object invokeSuspend(java.lang.Object r42) {
            /*
                Method dump skipped, instruction units count: 1492
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.phisher98.StreamPlayUtilsKt.C02832.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u001e\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"com/phisher98/StreamPlayUtilsKt$parseJsonToEpisodes$Response", "", "result", "", "Lcom/phisher98/EpisoderesponseKAA;", "<init>", "(Ljava/util/List;)V", "getResult", "()Ljava/util/List;", "component1", "copy", "(Ljava/util/List;)Lcom/phisher98/StreamPlayUtilsKt$parseJsonToEpisodes$Response;", "equals", "", "other", "hashCode", "", "toString", "", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Response {
        private final List<EpisoderesponseKAA> result;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Response copy$default(Response response, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = response.result;
            }
            return response.copy(list);
        }

        public final List<EpisoderesponseKAA> component1() {
            return this.result;
        }

        public final Response copy(List<EpisoderesponseKAA> result) {
            return new Response(result);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Response) && Intrinsics.areEqual(this.result, ((Response) other).result);
        }

        public int hashCode() {
            return this.result.hashCode();
        }

        public String toString() {
            return "Response(result=" + this.result + ')';
        }

        public Response(List<EpisoderesponseKAA> list) {
            this.result = list;
        }

        public final List<EpisoderesponseKAA> getResult() {
            return this.result;
        }
    }

    @NotNull
    public static final List<EpisoderesponseKAA> parseJsonToEpisodes(@NotNull String json) {
        Response response = (Response) getSharedGson().fromJson(json, Response.class);
        return response.getResult();
    }

    /* JADX WARN: Code duplicated, block: B:47:0x01b7 A[PHI: r0 r18 r24 r26 r27
      0x01b7: PHI (r0v6 '$this$getSignature_u24lambda_u240' java.lang.StringBuilder) = 
      (r0v5 '$this$getSignature_u24lambda_u240' java.lang.StringBuilder)
      (r0v7 '$this$getSignature_u24lambda_u240' java.lang.StringBuilder)
     binds: [B:46:0x01b5, B:42:0x0196] A[DONT_GENERATE, DONT_INLINE]
      0x01b7: PHI (r18v10 'order' java.util.List) = (r18v9 'order' java.util.List), (r18v11 'order' java.util.List) binds: [B:46:0x01b5, B:42:0x0196] A[DONT_GENERATE, DONT_INLINE]
      0x01b7: PHI (r24v6 'document' org.jsoup.nodes.Document) = (r24v5 'document' org.jsoup.nodes.Document), (r24v7 'document' org.jsoup.nodes.Document) binds: [B:46:0x01b5, B:42:0x0196] A[DONT_GENERATE, DONT_INLINE]
      0x01b7: PHI (r26v5 java.lang.String) = (r26v4 java.lang.String), (r26v6 java.lang.String) binds: [B:46:0x01b5, B:42:0x0196] A[DONT_GENERATE, DONT_INLINE]
      0x01b7: PHI (r27v4 'cidRaw' byte[]) = (r27v3 'cidRaw' byte[]), (r27v5 'cidRaw' byte[]) binds: [B:46:0x01b5, B:42:0x0196] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:64:0x0227 A[PHI: r0 r18 r24 r26 r27
      0x0227: PHI (r0v13 '$this$getSignature_u24lambda_u240' java.lang.StringBuilder) = 
      (r0v2 '$this$getSignature_u24lambda_u240' java.lang.StringBuilder)
      (r0v3 '$this$getSignature_u24lambda_u240' java.lang.StringBuilder)
      (r0v4 '$this$getSignature_u24lambda_u240' java.lang.StringBuilder)
      (r0v6 '$this$getSignature_u24lambda_u240' java.lang.StringBuilder)
      (r0v8 '$this$getSignature_u24lambda_u240' java.lang.StringBuilder)
      (r0v10 '$this$getSignature_u24lambda_u240' java.lang.StringBuilder)
      (r0v14 '$this$getSignature_u24lambda_u240' java.lang.StringBuilder)
     binds: [B:61:0x0220, B:54:0x01fb, B:50:0x01db, B:47:0x01b7, B:39:0x015e, B:35:0x012f, B:32:0x0119] A[DONT_GENERATE, DONT_INLINE]
      0x0227: PHI (r18v17 'order' java.util.List) = 
      (r18v6 'order' java.util.List)
      (r18v7 'order' java.util.List)
      (r18v8 'order' java.util.List)
      (r18v10 'order' java.util.List)
      (r18v12 'order' java.util.List)
      (r18v14 'order' java.util.List)
      (r18v18 'order' java.util.List)
     binds: [B:61:0x0220, B:54:0x01fb, B:50:0x01db, B:47:0x01b7, B:39:0x015e, B:35:0x012f, B:32:0x0119] A[DONT_GENERATE, DONT_INLINE]
      0x0227: PHI (r24v13 'document' org.jsoup.nodes.Document) = 
      (r24v2 'document' org.jsoup.nodes.Document)
      (r24v3 'document' org.jsoup.nodes.Document)
      (r24v4 'document' org.jsoup.nodes.Document)
      (r24v6 'document' org.jsoup.nodes.Document)
      (r24v9 'document' org.jsoup.nodes.Document)
      (r24v11 'document' org.jsoup.nodes.Document)
      (r24v14 'document' org.jsoup.nodes.Document)
     binds: [B:61:0x0220, B:54:0x01fb, B:50:0x01db, B:47:0x01b7, B:39:0x015e, B:35:0x012f, B:32:0x0119] A[DONT_GENERATE, DONT_INLINE]
      0x0227: PHI (r26v13 java.lang.String) = 
      (r26v1 java.lang.String)
      (r26v2 java.lang.String)
      (r26v3 java.lang.String)
      (r26v5 java.lang.String)
      (r26v8 java.lang.String)
      (r26v11 java.lang.String)
      (r26v14 java.lang.String)
     binds: [B:61:0x0220, B:54:0x01fb, B:50:0x01db, B:47:0x01b7, B:39:0x015e, B:35:0x012f, B:32:0x0119] A[DONT_GENERATE, DONT_INLINE]
      0x0227: PHI (r27v11 'cidRaw' byte[]) = 
      (r27v0 'cidRaw' byte[])
      (r27v1 'cidRaw' byte[])
      (r27v2 'cidRaw' byte[])
      (r27v4 'cidRaw' byte[])
      (r27v7 'cidRaw' byte[])
      (r27v9 'cidRaw' byte[])
      (r27v12 'cidRaw' byte[])
     binds: [B:61:0x0220, B:54:0x01fb, B:50:0x01db, B:47:0x01b7, B:39:0x015e, B:35:0x012f, B:32:0x0119] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0052, code lost:
    
        if (r29.equals("DuckStream") == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
    
        r3 = kotlin.collections.CollectionsKt.listOf(new java.lang.String[]{"IP", "USERAGENT", "ROUTE", "MID", "TIMESTAMP", "KEY"});
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002f, code lost:
    
        if (r29.equals("VidStreaming") != false) goto L16;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Triple<String, String, String> getSignature(@NotNull String html, @NotNull String server, @NotNull String query, @NotNull byte[] key) {
        String strHtml;
        String strSubstringAfter$default;
        String strSubstringBefore$default;
        String str;
        Document document;
        byte[] cidRaw;
        StringBuilder $this$getSignature_u24lambda_u240;
        List order;
        Map headers = MapsKt.mapOf(TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36"));
        String str2 = "ROUTE";
        switch (server.hashCode()) {
            case -2091769415:
                break;
            case 1265634745:
                if (server.equals("BirdStream")) {
                    List order2 = CollectionsKt.listOf(new String[]{"IP", "USERAGENT", "ROUTE", "MID", "KEY"});
                    Document document2 = Jsoup.parse(html);
                    Element element = (Element) CollectionsKt.firstOrNull(document2.select("script:containsData(cid:)"));
                    if (element == null || (strHtml = element.html()) == null || (strSubstringAfter$default = StringsKt.substringAfter$default(strHtml, "cid: '", (String) null, 2, (Object) null)) == null || (strSubstringBefore$default = StringsKt.substringBefore$default(strSubstringAfter$default, "'", (String) null, 2, (Object) null)) == null) {
                        return null;
                    }
                    byte[] cidRaw2 = decodeHex(strSubstringBefore$default);
                    if (cidRaw2 == null) {
                        return null;
                    }
                    List cid = StringsKt.split$default(new String(cidRaw2, Charsets.UTF_8), new String[]{"|"}, false, 0, 6, (Object) null);
                    String timeStamp = String.valueOf((System.currentTimeMillis() / 1000) + 60);
                    String route = StringsKt.replace$default((String) cid.get(1), "player.php", "source.php", false, 4, (Object) null);
                    StringBuilder sb = new StringBuilder();
                    StringBuilder $this$getSignature_u24lambda_u241 = sb;
                    List $this$forEach$iv = order2;
                    for (Object element$iv : $this$forEach$iv) {
                        String it = (String) element$iv;
                        switch (it.hashCode()) {
                            case -1453246218:
                                str = str2;
                                document = document2;
                                cidRaw = cidRaw2;
                                $this$getSignature_u24lambda_u240 = $this$getSignature_u24lambda_u241;
                                order = order2;
                                if (it.equals("TIMESTAMP")) {
                                    $this$getSignature_u24lambda_u240.append(timeStamp);
                                } else {
                                    Unit unit = Unit.INSTANCE;
                                }
                                break;
                            case -1167389190:
                                str = str2;
                                document = document2;
                                cidRaw = cidRaw2;
                                $this$getSignature_u24lambda_u240 = $this$getSignature_u24lambda_u241;
                                order = order2;
                                if (it.equals("USERAGENT")) {
                                    String str3 = (String) headers.get("User-Agent");
                                    if (str3 == null) {
                                        str3 = "";
                                    }
                                    $this$getSignature_u24lambda_u240.append(str3);
                                } else {
                                    Unit unit2 = Unit.INSTANCE;
                                }
                                break;
                            case 2343:
                                str = str2;
                                document = document2;
                                cidRaw = cidRaw2;
                                $this$getSignature_u24lambda_u240 = $this$getSignature_u24lambda_u241;
                                order = order2;
                                if (it.equals("IP")) {
                                    $this$getSignature_u24lambda_u240.append((String) cid.get(0));
                                } else {
                                    Unit unit3 = Unit.INSTANCE;
                                }
                                break;
                            case 74303:
                                str = str2;
                                document = document2;
                                cidRaw = cidRaw2;
                                $this$getSignature_u24lambda_u240 = $this$getSignature_u24lambda_u241;
                                order = order2;
                                if (it.equals("KEY")) {
                                    $this$getSignature_u24lambda_u240.append(new String(key, Charsets.UTF_8));
                                } else {
                                    Unit unit4 = Unit.INSTANCE;
                                }
                                break;
                            case 76328:
                                str = str2;
                                document = document2;
                                cidRaw = cidRaw2;
                                $this$getSignature_u24lambda_u240 = $this$getSignature_u24lambda_u241;
                                order = order2;
                                if (it.equals("MID")) {
                                    $this$getSignature_u24lambda_u240.append(query);
                                } else {
                                    Unit unit5 = Unit.INSTANCE;
                                }
                                break;
                            case 82097:
                                $this$getSignature_u24lambda_u240 = $this$getSignature_u24lambda_u241;
                                order = order2;
                                if (it.equals("SIG")) {
                                    str = str2;
                                    document = document2;
                                    cidRaw = cidRaw2;
                                    $this$getSignature_u24lambda_u240.append(StringsKt.substringBefore$default(StringsKt.substringAfter$default(html, "signature: '", (String) null, 2, (Object) null), "'", (String) null, 2, (Object) null));
                                } else {
                                    str = str2;
                                    document = document2;
                                    cidRaw = cidRaw2;
                                    Unit unit6 = Unit.INSTANCE;
                                }
                                break;
                            case 78166569:
                                if (it.equals(str2)) {
                                    $this$getSignature_u24lambda_u240 = $this$getSignature_u24lambda_u241;
                                    $this$getSignature_u24lambda_u240.append(route);
                                    order = order2;
                                    str = str2;
                                    document = document2;
                                    cidRaw = cidRaw2;
                                } else {
                                    str = str2;
                                    document = document2;
                                    cidRaw = cidRaw2;
                                    $this$getSignature_u24lambda_u240 = $this$getSignature_u24lambda_u241;
                                    order = order2;
                                    Unit unit7 = Unit.INSTANCE;
                                }
                                break;
                            default:
                                str = str2;
                                document = document2;
                                cidRaw = cidRaw2;
                                $this$getSignature_u24lambda_u240 = $this$getSignature_u24lambda_u241;
                                order = order2;
                                Unit unit8 = Unit.INSTANCE;
                                break;
                        }
                        order2 = order;
                        document2 = document;
                        str2 = str;
                        cidRaw2 = cidRaw;
                        $this$getSignature_u24lambda_u241 = $this$getSignature_u24lambda_u240;
                    }
                    return new Triple<>(sha1sum(sb.toString()), timeStamp, route);
                }
                return null;
            case 2026719089:
                break;
            default:
                return null;
        }
    }

    private static final String sha1sum(String value) throws Exception {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] bytes = value.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] bytes2 = md.digest(bytes);
            return ArraysKt.joinToString$default(bytes2, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StreamPlayUtilsKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj) {
                    return StreamPlayUtilsKt.sha1sum$lambda$0(((Byte) obj).byteValue());
                }
            }, 30, (Object) null);
        } catch (Exception e) {
            throw new Exception("Attempt to create the signature failed miserably.");
        }
    }

    static final CharSequence sha1sum$lambda$0(byte it) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(it)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    @NotNull
    public static final byte[] decodeHex(@NotNull String $this$decodeHex) {
        if (!($this$decodeHex.length() % 2 == 0)) {
            throw new IllegalStateException("Must have an even length".toString());
        }
        Iterable $this$map$iv = StringsKt.chunked($this$decodeHex, 2);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(Byte.valueOf((byte) Integer.parseInt(it, CharsKt.checkRadix(16))));
        }
        return CollectionsKt.toByteArray((List) destination$iv$iv);
    }

    @NotNull
    public static final Map<String, Set<String>> getLanguageMap() {
        return languageMap;
    }

    @NotNull
    public static final String getLanguage(@NotNull String code) {
        Object element$iv;
        String str;
        Map.Entry it;
        String lower = code.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lower, "toLowerCase(...)");
        Iterable $this$firstOrNull$iv = languageMap.entrySet();
        Iterator it2 = $this$firstOrNull$iv.iterator();
        do {
            if (!it2.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it2.next();
            it = (Map.Entry) element$iv;
        } while (!((Set) it.getValue()).contains(lower));
        Map.Entry entry = (Map.Entry) element$iv;
        return (entry == null || (str = (String) entry.getKey()) == null) ? "UnKnown" : str;
    }

    @Nullable
    public static final Integer getAnidbEid(@NotNull String jsonString, @Nullable Integer episodeNumber) {
        JSONObject jSONObjectOptJSONObject;
        if (episodeNumber == null) {
            return null;
        }
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONObject episodes = jsonObject.optJSONObject("episodes");
            if (episodes == null || (jSONObjectOptJSONObject = episodes.optJSONObject(String.valueOf(episodeNumber.intValue()))) == null) {
                return null;
            }
            Integer numValueOf = Integer.valueOf(jSONObjectOptJSONObject.optInt("anidbEid", -1));
            int it = numValueOf.intValue();
            if (it != -1) {
                return numValueOf;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @NotNull
    public static final Map<String, Function1<String, String>> getDecryptMethods() {
        return decryptMethods;
    }

    static final String decryptMethods$lambda$0(String inputString) {
        String it = StringsKt.replace$default(StringsKt.replace$default(StringsKt.reversed(inputString).toString(), "-", "+", false, 4, (Object) null), "_", "/", false, 4, (Object) null);
        CharSequence decoded = new String(Base64.decode(it, 0), Charsets.UTF_8);
        CharSequence $this$map$iv = decoded;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length());
        for (int i = 0; i < $this$map$iv.length(); i++) {
            char item$iv$iv = $this$map$iv.charAt(i);
            char ch = (char) (item$iv$iv - 7);
            destination$iv$iv.add(Character.valueOf(ch));
        }
        String it2 = CollectionsKt.joinToString$default((List) destination$iv$iv, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        return it2;
    }

    static final String decryptMethods$lambda$1(String inputString) {
        String reversed = StringsKt.reversed(inputString).toString();
        Iterable $this$map$iv = StringsKt.chunked(reversed, 2);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(Character.valueOf((char) Integer.parseInt(it, CharsKt.checkRadix(16))));
        }
        CharSequence hexPairs = CollectionsKt.joinToString$default((List) destination$iv$iv, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        CharSequence $this$mapIndexed$iv = hexPairs;
        Collection destination$iv$iv2 = new ArrayList($this$mapIndexed$iv.length());
        int index$iv$iv = 0;
        int i = 0;
        while (i < $this$mapIndexed$iv.length()) {
            char item$iv$iv2 = $this$mapIndexed$iv.charAt(i);
            destination$iv$iv2.add(Character.valueOf((char) ("X9a(O;FMV2-7VO5x;Ao\u0005:dN1NoFs?j,".charAt(index$iv$iv % "X9a(O;FMV2-7VO5x;Ao\u0005:dN1NoFs?j,".length()) ^ item$iv$iv2)));
            i++;
            index$iv$iv++;
        }
        return CollectionsKt.joinToString$default((List) destination$iv$iv2, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    static final String decryptMethods$lambda$2(String inputString) throws IOException {
        CharSequence $this$filterIndexed$iv = StringsKt.reversed(inputString).toString();
        CharSequence $this$filterIndexedTo$iv$iv = $this$filterIndexed$iv;
        Appendable destination$iv$iv = new StringBuilder();
        int index$iv$iv$iv = 0;
        int i = 0;
        while (i < $this$filterIndexedTo$iv$iv.length()) {
            char item$iv$iv$iv = $this$filterIndexedTo$iv$iv.charAt(i);
            int index$iv$iv$iv2 = index$iv$iv$iv + 1;
            int i2 = index$iv$iv$iv;
            if (i2 % 2 == 0) {
                destination$iv$iv.append(item$iv$iv$iv);
            }
            i++;
            index$iv$iv$iv = index$iv$iv$iv2;
        }
        String $this$filterIndexed$iv2 = ((StringBuilder) destination$iv$iv).toString();
        return new String(Base64.decode($this$filterIndexed$iv2, 0), Charsets.UTF_8);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0060  */
    /* JADX WARN: Code duplicated, block: B:33:0x0064  */
    static final String decryptMethods$lambda$3(String inputString) {
        char c;
        CharSequence reversed = StringsKt.reversed(inputString).toString();
        CharSequence $this$map$iv = reversed;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length());
        for (int i = 0; i < $this$map$iv.length(); i++) {
            char item$iv$iv = $this$map$iv.charAt(i);
            if ('a' <= item$iv$iv && item$iv$iv < 'n') {
                c = (char) (item$iv$iv + '\r');
            } else if ('A' <= item$iv$iv && item$iv$iv < 'N') {
                c = (char) (item$iv$iv + '\r');
            } else if ('n' <= item$iv$iv && item$iv$iv < '{') {
                c = (char) (item$iv$iv - '\r');
            } else if ('N' <= item$iv$iv && item$iv$iv < '[') {
                c = (char) (item$iv$iv - '\r');
            } else {
                c = item$iv$iv;
            }
            destination$iv$iv.add(Character.valueOf(c));
        }
        String rot13 = CollectionsKt.joinToString$default((List) destination$iv$iv, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        return new String(Base64.decode(StringsKt.reversed(rot13).toString(), 0), Charsets.UTF_8);
    }

    static final String decryptMethods$lambda$4(String inputString) {
        Map substitutionMap = MapsKt.toMap(StringsKt.zip("xyzabcdefghijklmnopqrstuvwXYZABCDEFGHIJKLMNOPQRSTUVW", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        String $this$map$iv = inputString;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length());
        for (int i = 0; i < $this$map$iv.length(); i++) {
            char item$iv$iv = $this$map$iv.charAt(i);
            char it = item$iv$iv;
            Character ch = (Character) substitutionMap.get(Character.valueOf(it));
            if (ch != null) {
                it = ch.charValue();
            }
            destination$iv$iv.add(Character.valueOf(it));
        }
        return CollectionsKt.joinToString$default((List) destination$iv$iv, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    static final String decryptMethods$lambda$5(String inputString) {
        CharSequence reversed = StringsKt.reversed(inputString).toString();
        CharSequence $this$map$iv = reversed;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length());
        for (int i = 0; i < $this$map$iv.length(); i++) {
            char item$iv$iv = $this$map$iv.charAt(i);
            char it = (char) (item$iv$iv - 1);
            destination$iv$iv.add(Character.valueOf(it));
        }
        String shifted = CollectionsKt.joinToString$default((List) destination$iv$iv, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        Iterable $this$map$iv2 = StringsKt.chunked(shifted, 2);
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            String it2 = (String) item$iv$iv2;
            destination$iv$iv2.add(Character.valueOf((char) Integer.parseInt(it2, CharsKt.checkRadix(16))));
        }
        return CollectionsKt.joinToString$default((List) destination$iv$iv2, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    static final String decryptMethods$lambda$6(String inputString) {
        String it = StringsKt.replace$default(StringsKt.replace$default(StringsKt.reversed(inputString).toString(), "-", "+", false, 4, (Object) null), "_", "/", false, 4, (Object) null);
        CharSequence decoded = new String(Base64.decode(it, 0), Charsets.UTF_8);
        CharSequence $this$map$iv = decoded;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length());
        for (int i = 0; i < $this$map$iv.length(); i++) {
            char item$iv$iv = $this$map$iv.charAt(i);
            char ch = (char) (item$iv$iv - 5);
            destination$iv$iv.add(Character.valueOf(ch));
        }
        String it2 = CollectionsKt.joinToString$default((List) destination$iv$iv, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        return it2;
    }

    static final String decryptMethods$lambda$7(String inputString) {
        Iterable $this$map$iv = StringsKt.chunked(inputString, 2);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(Character.valueOf((char) Integer.parseInt(it, CharsKt.checkRadix(16))));
        }
        CharSequence hexDecoded = CollectionsKt.joinToString$default((List) destination$iv$iv, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        CharSequence $this$mapIndexed$iv = hexDecoded;
        Collection destination$iv$iv2 = new ArrayList($this$mapIndexed$iv.length());
        int index$iv$iv = 0;
        int i = 0;
        while (i < $this$mapIndexed$iv.length()) {
            char item$iv$iv2 = $this$mapIndexed$iv.charAt(i);
            destination$iv$iv2.add(Character.valueOf((char) ("pWB9V)[*4I`nJpp?ozyB~dbr9yt!_n4u".charAt(index$iv$iv % "pWB9V)[*4I`nJpp?ozyB~dbr9yt!_n4u".length()) ^ item$iv$iv2)));
            i++;
            index$iv$iv++;
        }
        CharSequence decrypted = CollectionsKt.joinToString$default((List) destination$iv$iv2, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        CharSequence $this$map$iv2 = decrypted;
        Collection destination$iv$iv3 = new ArrayList($this$map$iv2.length());
        for (int i2 = 0; i2 < $this$map$iv2.length(); i2++) {
            char item$iv$iv3 = $this$map$iv2.charAt(i2);
            char it2 = (char) (item$iv$iv3 - 3);
            destination$iv$iv3.add(Character.valueOf(it2));
        }
        String shifted = CollectionsKt.joinToString$default((List) destination$iv$iv3, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        return new String(Base64.decode(shifted, 0), Charsets.UTF_8);
    }

    static final String decryptMethods$lambda$8(String inputString) {
        String it = StringsKt.replace$default(StringsKt.replace$default(StringsKt.reversed(inputString).toString(), "-", "+", false, 4, (Object) null), "_", "/", false, 4, (Object) null);
        CharSequence decoded = new String(Base64.decode(it, 0), Charsets.UTF_8);
        CharSequence $this$map$iv = decoded;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length());
        for (int i = 0; i < $this$map$iv.length(); i++) {
            char item$iv$iv = $this$map$iv.charAt(i);
            char ch = (char) (item$iv$iv - 3);
            destination$iv$iv.add(Character.valueOf(ch));
        }
        String it2 = CollectionsKt.joinToString$default((List) destination$iv$iv, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        return it2;
    }

    static final String decryptMethods$lambda$9(String input) {
        int i = 0;
        CharSequence decoded = new String(Base64.decode(StringsKt.dropLast(StringsKt.drop(input, 10), 16), 0), Charsets.UTF_8);
        CharSequence $this$mapIndexed$iv = decoded;
        Collection destination$iv$iv = new ArrayList($this$mapIndexed$iv.length());
        int index$iv$iv = 0;
        while (i < $this$mapIndexed$iv.length()) {
            char item$iv$iv = $this$mapIndexed$iv.charAt(i);
            destination$iv$iv.add(Character.valueOf((char) ("3SAY~#%Y(V%>5d/Yg$G[Lh1rK4a;7ok".charAt(index$iv$iv % "3SAY~#%Y(V%>5d/Yg$G[Lh1rK4a;7ok".length()) ^ item$iv$iv)));
            i++;
            index$iv$iv++;
        }
        return CollectionsKt.joinToString$default((List) destination$iv$iv, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    static final String decryptMethods$lambda$10(String x) {
        try {
            String strDrop = StringsKt.drop(x, 2);
            Function1 b1 = new Function1() { // from class: com.phisher98.StreamPlayUtilsKt$$ExternalSyntheticLambda24
                public final Object invoke(Object obj) {
                    return StreamPlayUtilsKt.decryptMethods$lambda$10$0((String) obj);
                }
            };
            Function1 b2 = new Function1() { // from class: com.phisher98.StreamPlayUtilsKt$$ExternalSyntheticLambda25
                public final Object invoke(Object obj) {
                    return StreamPlayUtilsKt.decryptMethods$lambda$10$1((String) obj);
                }
            };
            Iterable patterns = CollectionsKt.listOf(new String[]{"*,4).(_)()", "33-*.4/9[6", ":]&*1@@1=&", "=(=:19705/", "%?6497.[:4"});
            Iterable $this$forEach$iv = patterns;
            String strReplace$default = strDrop;
            for (Object element$iv : $this$forEach$iv) {
                String k = (String) element$iv;
                strReplace$default = StringsKt.replace$default(strReplace$default, "/@#@/" + ((String) b1.invoke(k)), "", false, 4, (Object) null);
            }
            return (String) b2.invoke(strReplace$default);
        } catch (Exception e) {
            return "Failed to decode: " + e.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String decryptMethods$lambda$10$0(String str) {
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return Base64.encodeToString(bytes, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String decryptMethods$lambda$10$1(String str) {
        return new String(Base64.decode(str, 0), Charsets.UTF_8);
    }

    @Nullable
    public static final MetaAnimeData parseAnimeData(@NotNull String jsonString) {
        try {
            return (MetaAnimeData) getSharedObjectMapper().readValue(jsonString, MetaAnimeData.class);
        } catch (Exception e) {
            return null;
        }
    }

    @NotNull
    public static final String cleanTitle(@NotNull String title) {
        String name = new Regex("\\.[a-zA-Z0-9]{2,4}$").replace(title, "");
        int i = 0;
        List<Regex> patterns = CollectionsKt.listOf(new Regex[]{new Regex("(WEB[-_. ]?DL|WEB[-_. ]?RIP|BLURAY|HDRIP|BDRIP|BRRIP|DVDRIP|HDTV|CAM|TS)", RegexOption.IGNORE_CASE), new Regex("(H[ .]?264|H[ .]?265|X264|X265|HEVC|AVC)", RegexOption.IGNORE_CASE), new Regex("(DDP[ .]?[0-9]\\.[0-9]|DD[ .]?[0-9]\\.[0-9]|AAC[ .]?[0-9]\\.[0-9]|AC3|DTS|EAC3|FLAC|MP3)", RegexOption.IGNORE_CASE), new Regex("(ATMOS|DUAL)", RegexOption.IGNORE_CASE), new Regex("(HDR10\\+?|HDR|DV|DOLBY[ .]?VISION)", RegexOption.IGNORE_CASE), new Regex("\\b(NF|AMZN|DSNP|HULU|CRAV|ATVP)\\b", RegexOption.IGNORE_CASE)});
        LinkedHashSet results = new LinkedHashSet();
        for (Regex pattern : patterns) {
            Sequence $this$forEach$iv = Regex.findAll$default(pattern, name, i, 2, (Object) null);
            for (Object element$iv : $this$forEach$iv) {
                MatchResult match = (MatchResult) element$iv;
                String value = match.getValue().toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(value, "toUpperCase(...)");
                results.add(StringsKt.replace$default(new Regex("DOLBY[ .]?VISION").replace(new Regex("H[ .]?264").replace(new Regex("H[ .]?265").replace(new Regex("WEB[-_. ]?RIP").replace(new Regex("WEB[-_. ]?DL").replace(value, "WEB-DL"), "WEBRIP"), "H265"), "H264"), "DOLBYVISION"), "2160P", "4K", false, 4, (Object) null));
            }
            i = 0;
        }
        return CollectionsKt.joinToString$default(results, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    @NotNull
    public static final String fixUrlPath(@NotNull String $this$fixUrlPath) {
        return StringsKt.contains$default($this$fixUrlPath, ".json?", false, 2, (Object) null) ? "https://allanime.day" + $this$fixUrlPath : "https://allanime.day" + new URI($this$fixUrlPath).getPath() + ".json?" + new URI($this$fixUrlPath).getQuery();
    }

    @NotNull
    public static final String decrypthex(@NotNull String inputStr) {
        String hexString;
        if (StringsKt.startsWith$default(inputStr, "-", false, 2, (Object) null)) {
            hexString = StringsKt.substringAfterLast$default(inputStr, "-", (String) null, 2, (Object) null);
        } else {
            hexString = inputStr;
        }
        int length = hexString.length() / 2;
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            String hexByte = hexString.substring(i2, i2 + 2);
            Intrinsics.checkNotNullExpressionValue(hexByte, "substring(...)");
            bytes[i] = (byte) (Integer.parseInt(hexByte, CharsKt.checkRadix(16)) & 255);
        }
        return ArraysKt.joinToString$default(bytes, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StreamPlayUtilsKt$$ExternalSyntheticLambda26
            public final Object invoke(Object obj) {
                return String.valueOf((char) (((Byte) obj).byteValue() ^ 56));
            }
        }, 30, (Object) null);
    }

    @Nullable
    public static final Object getM3u8Qualities(@NotNull String m3u8Link, @NotNull String referer, @NotNull String qualityName, @NotNull Continuation<? super List<? extends ExtractorLink>> continuation) {
        return M3u8Helper.Companion.generateM3u8$default(M3u8Helper.Companion, qualityName, m3u8Link, referer, (Integer) null, (Map) null, (String) null, continuation, 56, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:29:0x0109  */
    /* JADX WARN: Code duplicated, block: B:31:0x0113  */
    /* JADX WARN: Code duplicated, block: B:32:0x0118  */
    /* JADX WARN: Code duplicated, block: B:39:0x0129  */
    /* JADX WARN: Code duplicated, block: B:41:0x012d  */
    /* JADX WARN: Code duplicated, block: B:49:0x0221 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:0x0222  */
    /* JADX WARN: Code duplicated, block: B:63:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:66:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:67:0x02be  */
    /* JADX WARN: Code duplicated, block: B:69:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:70:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Code duplicated, block: B:97:0x0130 A[SYNTHETIC] */
    @Nullable
    public static final Object getRedirectLinks(@NotNull String url, @NotNull Continuation<? super String> continuation) {
        C02791 c02791;
        int i;
        String str;
        C02791 c02792;
        Object obj;
        String url2;
        String doc;
        Regex regex;
        StringBuilder $this$getRedirectLinks_u24lambda_u240;
        Regex regex2;
        String combinedString;
        Regex regex3;
        String str2;
        String encodedurl;
        String str3;
        String combinedString2;
        String doc2;
        Regex regex4;
        String url3;
        String encodedurl2;
        String url4;
        MatchResult matchResult;
        MatchGroup matchGroup;
        MatchGroup matchGroup2;
        String extractedValue;
        String str4;
        boolean z;
        Object obj2;
        Object obj3;
        String directlink;
        String str5;
        boolean z2;
        if (continuation instanceof C02791) {
            c02791 = (C02791) continuation;
            if ((c02791.label & Integer.MIN_VALUE) != 0) {
                c02791.label -= Integer.MIN_VALUE;
            } else {
                c02791 = new C02791(continuation);
            }
        } else {
            c02791 = new C02791(continuation);
        }
        C02791 c02793 = c02791;
        Object $result = c02793.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c02793.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c02793.L$0 = url;
                c02793.label = 1;
                i = 0;
                str = "";
                Object obj4 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02793, 4094, (Object) null);
                c02792 = c02793;
                if (obj4 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = obj4;
                url2 = url;
                doc = ((NiceResponse) obj).toString();
                regex = new Regex("s\\('o','([A-Za-z0-9+/=]+)'|ck\\('_wp_http_\\d+','([^']+)'");
                $this$getRedirectLinks_u24lambda_u240 = new StringBuilder();
                Sequence $this$forEach$iv = Regex.findAll$default(regex, doc, i, 2, (Object) null);
                for (Object element$iv : $this$forEach$iv) {
                    matchResult = (MatchResult) element$iv;
                    Regex regex5 = regex;
                    matchGroup = matchResult.getGroups().get(1);
                    if (matchGroup != null || (extractedValue = matchGroup.getValue()) == null) {
                        matchGroup2 = matchResult.getGroups().get(2);
                        if (matchGroup2 != null) {
                            extractedValue = matchGroup2.getValue();
                        } else {
                            extractedValue = null;
                        }
                    }
                    str4 = extractedValue;
                    if (str4 != null || str4.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        $this$getRedirectLinks_u24lambda_u240.append(extractedValue);
                    }
                    regex = regex5;
                }
                regex2 = regex;
                combinedString = $this$getRedirectLinks_u24lambda_u240.toString();
                try {
                    String decodedString = MainAPIKt.base64Decode(hdhubpen(MainAPIKt.base64Decode(MainAPIKt.base64Decode(combinedString))));
                    JSONObject jsonObject = new JSONObject(decodedString);
                    str2 = str;
                    encodedurl = StringsKt.trim(MainAPIKt.base64Decode(jsonObject.optString("o", str2))).toString();
                    String data = StringsKt.trim(hdhubencode(jsonObject.optString("data", str2))).toString();
                    String wphttp1 = StringsKt.trim(jsonObject.optString("blog_url", str2)).toString();
                    try {
                        Result.Companion companion = Result.Companion;
                        Requests app2 = MainActivityKt.getApp();
                        String string = StringsKt.trim(wphttp1 + "?re=" + data).toString();
                        c02792.L$0 = url2;
                        c02792.L$1 = SpillingKt.nullOutSpilledVariable(doc);
                        c02792.L$2 = SpillingKt.nullOutSpilledVariable(regex2);
                        c02792.L$3 = SpillingKt.nullOutSpilledVariable(combinedString);
                        c02792.L$4 = SpillingKt.nullOutSpilledVariable(decodedString);
                        c02792.L$5 = SpillingKt.nullOutSpilledVariable(jsonObject);
                        c02792.L$6 = encodedurl;
                        c02792.L$7 = SpillingKt.nullOutSpilledVariable(data);
                        c02792.L$8 = SpillingKt.nullOutSpilledVariable(wphttp1);
                        c02792.label = 2;
                        url4 = url2;
                        str3 = str2;
                        try {
                            $result = Requests.get$default(app2, string, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02792, 4094, (Object) null);
                            if ($result == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            combinedString2 = combinedString;
                            doc2 = doc;
                            regex4 = regex2;
                            url3 = url4;
                            encodedurl2 = encodedurl;
                            try {
                                obj2 = Result.constructor-impl(StringsKt.trim(((NiceResponse) $result).getDocument().select("body").text()).toString());
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    Result.Companion companion2 = Result.Companion;
                                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                } catch (Exception e) {
                                    e = e;
                                    regex3 = regex4;
                                    url2 = url3;
                                    Log.INSTANCE.e("Error:", "Error processing links " + e);
                                    return url2;
                                }
                            }
                            obj3 = obj2;
                            url2 = url3;
                            try {
                                if (Result.isFailure-impl(obj3)) {
                                    obj3 = str3;
                                }
                                directlink = StringsKt.trim((String) obj3).toString();
                                str5 = encodedurl2;
                                if (str5.length() == 0) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (!z2) {
                                    directlink = str5;
                                }
                                return directlink;
                            } catch (Exception e2) {
                                e = e2;
                                regex3 = regex4;
                                Log.INSTANCE.e("Error:", "Error processing links " + e);
                                return url2;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            combinedString2 = combinedString;
                            doc2 = doc;
                            regex4 = regex2;
                            url3 = url4;
                            encodedurl2 = encodedurl;
                            Result.Companion companion3 = Result.Companion;
                            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                            obj3 = obj2;
                            url2 = url3;
                            if (Result.isFailure-impl(obj3)) {
                                obj3 = str3;
                            }
                            directlink = StringsKt.trim((String) obj3).toString();
                            str5 = encodedurl2;
                            if (str5.length() == 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                directlink = str5;
                            }
                            return directlink;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str3 = str2;
                        combinedString2 = combinedString;
                        doc2 = doc;
                        regex4 = regex2;
                        url3 = url2;
                        encodedurl2 = encodedurl;
                    }
                } catch (Exception e3) {
                    e = e3;
                    regex3 = regex2;
                    Log.INSTANCE.e("Error:", "Error processing links " + e);
                    return url2;
                }
                break;
                break;
            case 1:
                String url5 = (String) c02793.L$0;
                ResultKt.throwOnFailure($result);
                str = "";
                i = 0;
                c02792 = c02793;
                url2 = url5;
                obj = $result;
                doc = ((NiceResponse) obj).toString();
                regex = new Regex("s\\('o','([A-Za-z0-9+/=]+)'|ck\\('_wp_http_\\d+','([^']+)'");
                $this$getRedirectLinks_u24lambda_u240 = new StringBuilder();
                Sequence $this$forEach$iv2 = Regex.findAll$default(regex, doc, i, 2, (Object) null);
                while (r12.hasNext()) {
                    matchResult = (MatchResult) element$iv;
                    Regex regex6 = regex;
                    matchGroup = matchResult.getGroups().get(1);
                    if (matchGroup != null) {
                        matchGroup2 = matchResult.getGroups().get(2);
                        if (matchGroup2 != null) {
                            extractedValue = matchGroup2.getValue();
                        } else {
                            extractedValue = null;
                        }
                    } else {
                        matchGroup2 = matchResult.getGroups().get(2);
                        if (matchGroup2 != null) {
                            extractedValue = matchGroup2.getValue();
                        } else {
                            extractedValue = null;
                        }
                    }
                    str4 = extractedValue;
                    if (str4 != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        $this$getRedirectLinks_u24lambda_u240.append(extractedValue);
                    }
                    regex = regex6;
                }
                regex2 = regex;
                combinedString = $this$getRedirectLinks_u24lambda_u240.toString();
                String decodedString2 = MainAPIKt.base64Decode(hdhubpen(MainAPIKt.base64Decode(MainAPIKt.base64Decode(combinedString))));
                JSONObject jsonObject2 = new JSONObject(decodedString2);
                str2 = str;
                encodedurl = StringsKt.trim(MainAPIKt.base64Decode(jsonObject2.optString("o", str2))).toString();
                String data2 = StringsKt.trim(hdhubencode(jsonObject2.optString("data", str2))).toString();
                String wphttp2 = StringsKt.trim(jsonObject2.optString("blog_url", str2)).toString();
                Result.Companion companion4 = Result.Companion;
                Requests app3 = MainActivityKt.getApp();
                String string2 = StringsKt.trim(wphttp2 + "?re=" + data2).toString();
                c02792.L$0 = url2;
                c02792.L$1 = SpillingKt.nullOutSpilledVariable(doc);
                c02792.L$2 = SpillingKt.nullOutSpilledVariable(regex2);
                c02792.L$3 = SpillingKt.nullOutSpilledVariable(combinedString);
                c02792.L$4 = SpillingKt.nullOutSpilledVariable(decodedString2);
                c02792.L$5 = SpillingKt.nullOutSpilledVariable(jsonObject2);
                c02792.L$6 = encodedurl;
                c02792.L$7 = SpillingKt.nullOutSpilledVariable(data2);
                c02792.L$8 = SpillingKt.nullOutSpilledVariable(wphttp2);
                c02792.label = 2;
                url4 = url2;
                str3 = str2;
                $result = Requests.get$default(app3, string2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02792, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                combinedString2 = combinedString;
                doc2 = doc;
                regex4 = regex2;
                url3 = url4;
                encodedurl2 = encodedurl;
                obj2 = Result.constructor-impl(StringsKt.trim(((NiceResponse) $result).getDocument().select("body").text()).toString());
                obj3 = obj2;
                url2 = url3;
                if (Result.isFailure-impl(obj3)) {
                    obj3 = str3;
                }
                directlink = StringsKt.trim((String) obj3).toString();
                str5 = encodedurl2;
                if (str5.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    directlink = str5;
                }
                return directlink;
            case 2:
                encodedurl2 = (String) c02793.L$6;
                combinedString2 = (String) c02793.L$3;
                regex4 = (Regex) c02793.L$2;
                doc2 = (String) c02793.L$1;
                url3 = (String) c02793.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    str3 = "";
                    obj2 = Result.constructor-impl(StringsKt.trim(((NiceResponse) $result).getDocument().select("body").text()).toString());
                    break;
                } catch (Throwable th4) {
                    th = th4;
                    str3 = "";
                    Result.Companion companion5 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                    obj3 = obj2;
                    url2 = url3;
                    if (Result.isFailure-impl(obj3)) {
                        obj3 = str3;
                    }
                    directlink = StringsKt.trim((String) obj3).toString();
                    str5 = encodedurl2;
                    if (str5.length() == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        directlink = str5;
                    }
                    return directlink;
                }
                obj3 = obj2;
                url2 = url3;
                if (Result.isFailure-impl(obj3)) {
                    obj3 = str3;
                }
                directlink = StringsKt.trim((String) obj3).toString();
                str5 = encodedurl2;
                if (str5.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    directlink = str5;
                }
                return directlink;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @NotNull
    public static final String hdhubencode(@NotNull String encoded) {
        return new String(Base64.decode(encoded, 0), Charsets.UTF_8);
    }

    @NotNull
    public static final String hdhubpen(@NotNull String value) {
        char c;
        String $this$map$iv = value;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length());
        for (int i = 0; i < $this$map$iv.length(); i++) {
            char item$iv$iv = $this$map$iv.charAt(i);
            if ('A' <= item$iv$iv && item$iv$iv < '[') {
                c = (char) ((((item$iv$iv - 'A') + 13) % 26) + 65);
            } else if ('a' <= item$iv$iv && item$iv$iv < '{') {
                c = (char) ((((item$iv$iv - 'a') + 13) % 26) + 97);
            } else {
                c = item$iv$iv;
            }
            destination$iv$iv.add(Character.valueOf(c));
        }
        return CollectionsKt.joinToString$default((List) destination$iv$iv, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    private static final String md5(byte[] input) {
        return ArraysKt.joinToString$default(MessageDigest.getInstance("MD5").digest(input), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StreamPlayUtilsKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return StreamPlayUtilsKt.md5$lambda$0(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    static final CharSequence md5$lambda$0(byte it) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(it)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private static final String reverseString(String input) {
        return StringsKt.reversed(input).toString();
    }

    public static /* synthetic */ String generateXClientToken$default(Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        return generateXClientToken(l);
    }

    @NotNull
    public static final String generateXClientToken(@Nullable Long hardcodedTimestamp) {
        String timestamp = String.valueOf(hardcodedTimestamp != null ? hardcodedTimestamp.longValue() : System.currentTimeMillis());
        String reversed = reverseString(timestamp);
        byte[] bytes = reversed.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String hash = md5(bytes);
        return timestamp + ',' + hash;
    }

    public static /* synthetic */ String generateXTrSignature$default(String str, String str2, String str3, String str4, String str5, boolean z, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "application/json";
        }
        if ((i & 4) != 0) {
            str3 = "application/json";
        }
        if ((i & 16) != 0) {
            str5 = null;
        }
        if ((i & 32) != 0) {
            z = false;
        }
        if ((i & 64) != 0) {
            l = null;
        }
        return generateXTrSignature(str, str2, str3, str4, str5, z, l);
    }

    @NotNull
    public static final String generateXTrSignature(@NotNull String method, @Nullable String accept, @Nullable String contentType, @NotNull String url, @Nullable String body, boolean useAltKey, @Nullable Long hardcodedTimestamp) throws NoSuchAlgorithmException, InvalidKeyException {
        String secretKey;
        long timestamp = hardcodedTimestamp != null ? hardcodedTimestamp.longValue() : System.currentTimeMillis();
        String canonical = buildCanonicalString(method, accept, contentType, url, body, timestamp);
        if (useAltKey) {
            secretKey = "Xqn2nnO41/L92o1iuXhSLHTbXvY4Z5ZZ62m8mSLA";
        } else {
            secretKey = "76iRl07s0xSN9jqmEWAt79EBJZulIQIsV64FZr2O";
        }
        byte[] secretBytes = Base64.decode(secretKey, 0);
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(new SecretKeySpec(secretBytes, "HmacMD5"));
        byte[] bytes = canonical.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] rawSignature = mac.doFinal(bytes);
        String signatureBase64 = Base64.encodeToString(rawSignature, 2);
        return timestamp + "|2|" + signatureBase64;
    }

    private static final String buildCanonicalString(String method, String accept, String contentType, String url, String body, long timestamp) {
        byte[] bodyBytes;
        String bodyHash;
        String bodyLength;
        final Uri parsed = Uri.parse(url);
        Intrinsics.checkExpressionValueIsNotNull(parsed, "Uri.parse(this)");
        String path = parsed.getPath();
        if (path == null) {
            path = "";
        }
        String query = !parsed.getQueryParameterNames().isEmpty() ? CollectionsKt.joinToString$default(CollectionsKt.sorted(parsed.getQueryParameterNames()), "&", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StreamPlayUtilsKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                String str = (String) obj;
                return CollectionsKt.joinToString$default(parsed.getQueryParameters(str), "&", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StreamPlayUtilsKt$$ExternalSyntheticLambda23
                    public final Object invoke(Object obj2) {
                        return StreamPlayUtilsKt.buildCanonicalString$lambda$0$0(str, (String) obj2);
                    }
                }, 30, (Object) null);
            }
        }, 30, (Object) null) : "";
        String canonicalUrl = query.length() > 0 ? path + '?' + query : path;
        if (body != null) {
            bodyBytes = body.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bodyBytes, "getBytes(...)");
        } else {
            bodyBytes = null;
        }
        if (bodyBytes != null) {
            byte[] trimmed = bodyBytes.length > 102400 ? ArraysKt.copyOfRange(bodyBytes, 0, 102400) : bodyBytes;
            bodyHash = md5(trimmed);
        } else {
            bodyHash = "";
        }
        if (bodyBytes == null || (bodyLength = String.valueOf(bodyBytes.length)) == null) {
            bodyLength = "";
        }
        StringBuilder sb = new StringBuilder();
        String upperCase = method.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return sb.append(upperCase).append('\n').append(accept == null ? "" : accept).append('\n').append(contentType != null ? contentType : "").append('\n').append(bodyLength).append('\n').append(timestamp).append('\n').append(bodyHash).append('\n').append(canonicalUrl).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence buildCanonicalString$lambda$0$0(String $key, String value) {
        return $key + '=' + value;
    }

    public static /* synthetic */ String vidrockEncode$default(Integer num, String str, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        if ((i & 8) != 0) {
            num3 = null;
        }
        return vidrockEncode(num, str, num2, num3);
    }

    @NotNull
    public static final String vidrockEncode(@Nullable Integer tmdb, @NotNull String type, @Nullable Integer season, @Nullable Integer episode) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Object string;
        String zw = MainAPIKt.base64Decode("eDdrOW1QcVQycld2WTh6QTViQzNuRjZoSjJsSzRtTjk=");
        if (Intrinsics.areEqual(type, "tv") && season != null && episode != null) {
            string = new StringBuilder().append(tmdb).append('_').append(season.intValue()).append('_').append(episode.intValue()).toString();
        } else {
            string = tmdb;
        }
        String s = String.valueOf(string);
        byte[] keyBytes = zw.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(keyBytes, "getBytes(...)");
        String strSubstring = zw.substring(0, 16);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        byte[] ivBytes = strSubstring.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(ivBytes, "getBytes(...)");
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, keySpec, ivSpec);
        byte[] bytes = s.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] encrypted = cipher.doFinal(bytes);
        String base64 = MainAPIKt.base64Encode(encrypted);
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(base64, "+", "-", false, 4, (Object) null), "/", "_", false, 4, (Object) null), "=", "", false, 4, (Object) null);
    }

    @NotNull
    public static final byte[] fromHex(@NotNull String hex) {
        String cleanHex = new Regex("[^0-9a-fA-F]").replace(hex, "");
        if (!(cleanHex.length() % 2 == 0)) {
            throw new IllegalArgumentException("Invalid hex".toString());
        }
        int length = cleanHex.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            String strSubstring = cleanHex.substring(i2, i2 + 2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            bArr[i] = (byte) Integer.parseInt(strSubstring, CharsKt.checkRadix(16));
        }
        return bArr;
    }

    @NotNull
    public static final SecretKeySpec importKey(@NotNull byte[] rawKey) {
        if (rawKey.length == 16 || rawKey.length == 32) {
            return new SecretKeySpec(rawKey, "AES");
        }
        throw new IllegalArgumentException("AES_KEY must be 16 or 32 bytes".toString());
    }

    public static /* synthetic */ Object runLimitedAsync$default(int i, Function1[] function1Arr, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 5;
        }
        return runLimitedAsync(i, function1Arr, continuation);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayUtilsKt$runLimitedAsync$2 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayUtilsKt$runLimitedAsync$2", f = "StreamPlayUtils.kt", i = {0, 1, 1, 1}, l = {1270, 1286}, m = "invokeSuspend", n = {"$this$coroutineScope", "$this$coroutineScope", "e", "semaphore"}, nl = {1271, 1287}, s = {"L$0", "L$0", "L$1", "L$2"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$runLimitedAsync$2\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,2265:1\n12746#2:2266\n13093#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$runLimitedAsync$2\n*L\n1275#1:2266\n1275#1:2267,3\n*E\n"})
    static final class C02902 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
        final /* synthetic */ int $concurrency;
        final /* synthetic */ Function1<Continuation<? super Unit>, Object>[] $tasks;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02902(int i, Function1<? super Continuation<? super Unit>, ? extends Object>[] function1Arr, Continuation<? super C02902> continuation) {
            super(2, continuation);
            this.$concurrency = i;
            this.$tasks = function1Arr;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c02902 = new C02902(this.$concurrency, this.$tasks, continuation);
            c02902.L$0 = obj;
            return c02902;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<Object> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object objRunLimitedAsync;
            CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.L$0 = $this$coroutineScope;
                        this.label = 1;
                        objRunLimitedAsync = StreamPlayConcurrency.INSTANCE.runLimitedAsync(this.$concurrency, (Function1[]) Arrays.copyOf(this.$tasks, this.$tasks.length), (Continuation) this);
                        if (objRunLimitedAsync == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        objRunLimitedAsync = $result;
                        break;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return objRunLimitedAsync;
            } catch (Exception e) {
                int i = 0;
                Semaphore semaphore = SemaphoreKt.Semaphore$default(this.$concurrency, 0, 2, (Object) null);
                Object[] $this$map$iv = this.$tasks;
                Collection destination$iv$iv = new ArrayList($this$map$iv.length);
                for (int length = $this$map$iv.length; i < length; length = length) {
                    Object item$iv$iv = $this$map$iv[i];
                    destination$iv$iv.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new StreamPlayUtilsKt$runLimitedAsync$2$1$1(semaphore, (Function1) item$iv$iv, null), 2, (Object) null));
                    i++;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(e);
                this.L$2 = SpillingKt.nullOutSpilledVariable(semaphore);
                this.label = 2;
                Object objAwaitAll = AwaitKt.awaitAll((List) destination$iv$iv, (Continuation) this);
                return objAwaitAll == coroutine_suspended ? coroutine_suspended : objAwaitAll;
            }
        }
    }

    @Nullable
    public static final Object runLimitedAsync(int concurrency, @NotNull Function1<? super Continuation<? super Unit>, ? extends Object>[] function1Arr, @NotNull Continuation<Object> continuation) {
        return CoroutineScopeKt.coroutineScope(new C02902(concurrency, function1Arr, null), continuation);
    }

    @NotNull
    public static final String decryptVidzeeUrl(@NotNull String encrypted, @NotNull byte[] key) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        String decoded = MainAPIKt.base64Decode(encrypted);
        List parts = StringsKt.split$default(decoded, new String[]{":"}, false, 0, 6, (Object) null);
        if (parts.size() != 2) {
            throw new IllegalArgumentException("Invalid encrypted format");
        }
        byte[] iv = MainAPIKt.base64DecodeArray((String) parts.get(0));
        byte[] cipherData = MainAPIKt.base64DecodeArray((String) parts.get(1));
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        cipher.init(2, secretKey, new IvParameterSpec(iv));
        byte[] decryptedBytes = cipher.doFinal(cipherData);
        return new String(decryptedBytes, Charsets.UTF_8);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Nullable
    public static final Object yflixDecode(@Nullable String text, @NotNull Continuation<? super String> continuation) {
        C02941 c02941;
        if (continuation instanceof C02941) {
            c02941 = (C02941) continuation;
            if ((c02941.label & Integer.MIN_VALUE) != 0) {
                c02941.label -= Integer.MIN_VALUE;
            } else {
                c02941 = new C02941(continuation);
            }
        } else {
            c02941 = new C02941(continuation);
        }
        C02941 c02942 = c02941;
        Object $result = c02942.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c02942.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    Requests app = MainActivityKt.getApp();
                    String str = "https://enc-dec.app/api/enc-movies-flix?text=" + text;
                    c02942.L$0 = SpillingKt.nullOutSpilledVariable(text);
                    c02942.label = 1;
                    try {
                        $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02942, 4094, (Object) null);
                        if ($result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        try {
                            String res = ((NiceResponse) $result).getText();
                            return new JSONObject(res).getString("result");
                        } catch (Exception e) {
                            return "";
                        }
                    } catch (Exception e2) {
                        return "";
                    }
                } catch (Exception e3) {
                }
                break;
            case 1:
                try {
                    ResultKt.throwOnFailure($result);
                    String res2 = ((NiceResponse) $result).getText();
                    return new JSONObject(res2).getString("result");
                } catch (Exception e4) {
                    return "";
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Nullable
    public static final Object yflixDecodeReverse(@NotNull String text, @NotNull Continuation<? super String> continuation) {
        C02951 c02951;
        if (continuation instanceof C02951) {
            c02951 = (C02951) continuation;
            if ((c02951.label & Integer.MIN_VALUE) != 0) {
                c02951.label -= Integer.MIN_VALUE;
            } else {
                c02951 = new C02951(continuation);
            }
        } else {
            c02951 = new C02951(continuation);
        }
        C02951 c02952 = c02951;
        Object $result = c02952.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c02952.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                RequestBody jsonBody = RequestBody.Companion.create("{\"text\":\"" + text + "\"}", JSON);
                try {
                    Requests app = MainActivityKt.getApp();
                    try {
                        c02952.L$0 = SpillingKt.nullOutSpilledVariable(text);
                        c02952.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody);
                        c02952.label = 1;
                        try {
                            $result = Requests.post$default(app, "https://enc-dec.app/api/dec-movies-flix", (Map) null, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, jsonBody, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02952, 65278, (Object) null);
                            if ($result == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            try {
                                String res = ((NiceResponse) $result).getText();
                                return new JSONObject(res).getString("result");
                            } catch (Exception e) {
                                return "";
                            }
                        } catch (Exception e2) {
                            return "";
                        }
                    } catch (Exception e3) {
                    }
                } catch (Exception e4) {
                }
                break;
            case 1:
                try {
                    ResultKt.throwOnFailure($result);
                    String res2 = ((NiceResponse) $result).getText();
                    return new JSONObject(res2).getString("result");
                } catch (Exception e5) {
                    return "";
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @NotNull
    public static final String yflixextractVideoUrlFromJson(@NotNull String jsonData) {
        JSONObject jsonObject = new JSONObject(jsonData);
        return jsonObject.getString("url");
    }

    @NotNull
    public static final String fixSourceUrl(@NotNull String $this$fixSourceUrl) {
        return StringsKt.replace$default(StringsKt.replace$default($this$fixSourceUrl, "/manifest.json", "", false, 4, (Object) null), "stremio://", "https://", false, 4, (Object) null);
    }

    @NotNull
    public static final String generateHexKey32() {
        byte[] bytes = new byte[32];
        new SecureRandom().nextBytes(bytes);
        return ArraysKt.joinToString$default(bytes, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StreamPlayUtilsKt$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                return StreamPlayUtilsKt.generateHexKey32$lambda$0(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    static final CharSequence generateHexKey32$lambda$0(byte it) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(it)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0242 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:101:0x0244  */
    /* JADX WARN: Code duplicated, block: B:103:0x024b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:112:0x01e9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:0x01f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:0x01f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x0236 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:124:0x0236 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:125:0x0236 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x0164  */
    /* JADX WARN: Code duplicated, block: B:45:0x0169 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x016a  */
    /* JADX WARN: Code duplicated, block: B:54:0x017e  */
    /* JADX WARN: Code duplicated, block: B:59:0x019e  */
    /* JADX WARN: Code duplicated, block: B:62:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:64:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:65:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:67:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:69:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:73:0x01ee A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:75:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:79:0x0204  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:81:0x020b  */
    /* JADX WARN: Code duplicated, block: B:83:0x0214  */
    /* JADX WARN: Code duplicated, block: B:86:0x021b  */
    /* JADX WARN: Code duplicated, block: B:90:0x0227  */
    /* JADX WARN: Code duplicated, block: B:92:0x022d  */
    /* JADX WARN: Code duplicated, block: B:93:0x022f  */
    /* JADX WARN: Code duplicated, block: B:95:0x0235  */
    /* JADX WARN: Code duplicated, block: B:98:0x023b  */
    @Nullable
    public static final Object fetchTmdbLogoUrl(@NotNull String tmdbAPI, @NotNull String apiKey, @NotNull TvType type, @Nullable Integer tmdbId, @Nullable String appLangCode, @NotNull Continuation<? super String> continuation) {
        C02751 c02751;
        String tmdbAPI2;
        String appLangCode2;
        String apiKey2;
        Object obj;
        Object obj2;
        JSONObject json;
        JSONArray logos;
        String lang;
        JSONObject svgFallback;
        int i;
        int length;
        String str;
        JSONObject best;
        JSONObject bestSvg;
        int i2;
        int length2;
        JSONObject logo;
        JSONObject logo2;
        String p;
        String str2;
        String tmdbAPI3;
        String l;
        String string;
        if (continuation instanceof C02751) {
            c02751 = (C02751) continuation;
            if ((c02751.label & Integer.MIN_VALUE) != 0) {
                c02751.label -= Integer.MIN_VALUE;
            } else {
                c02751 = new C02751(continuation);
            }
        } else {
            c02751 = new C02751(continuation);
        }
        C02751 c02752 = c02751;
        Object $result = c02752.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c02752.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (tmdbId == null) {
                    return null;
                }
                String url = type == TvType.Movie ? tmdbAPI + "/movie/" + tmdbId.intValue() + "/images?api_key=" + apiKey : tmdbAPI + "/tv/" + tmdbId.intValue() + "/images?api_key=" + apiKey;
                try {
                    Result.Companion companion = Result.Companion;
                    Requests app = MainActivityKt.getApp();
                    c02752.L$0 = SpillingKt.nullOutSpilledVariable(tmdbAPI);
                    c02752.L$1 = SpillingKt.nullOutSpilledVariable(apiKey);
                    c02752.L$2 = SpillingKt.nullOutSpilledVariable(type);
                    c02752.L$3 = SpillingKt.nullOutSpilledVariable(tmdbId);
                    c02752.L$4 = appLangCode;
                    c02752.L$5 = SpillingKt.nullOutSpilledVariable(url);
                    c02752.label = 1;
                    tmdbAPI2 = null;
                    try {
                        Object obj3 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02752, 4094, (Object) null);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        appLangCode2 = appLangCode;
                        $result = obj3;
                        apiKey2 = tmdbAPI;
                        try {
                            obj = Result.constructor-impl(new JSONObject(((NiceResponse) $result).getText()));
                            break;
                        } catch (Throwable th) {
                            th = th;
                            Object $result2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        obj2 = obj;
                        if (Result.isFailure-impl(obj2)) {
                            obj2 = tmdbAPI2;
                        }
                        json = (JSONObject) obj2;
                        if (json != null || (logos = json.optJSONArray("logos")) == null || logos.length() == 0) {
                            return tmdbAPI2;
                        }
                        if (appLangCode2 != null || (string = StringsKt.trim(appLangCode2).toString()) == null) {
                            lang = tmdbAPI2;
                        } else {
                            String lowerCase = string.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            if (lowerCase != null) {
                                lang = StringsKt.substringBefore$default(lowerCase, "-", tmdbAPI2, 2, tmdbAPI2);
                            } else {
                                lang = tmdbAPI2;
                            }
                        }
                        svgFallback = null;
                        i = 0;
                        length = logos.length();
                        while (i < length) {
                            logo2 = logos.optJSONObject(i);
                            if (logo2 == null) {
                                str2 = tmdbAPI2;
                                tmdbAPI3 = apiKey2;
                            } else {
                                p = fetchTmdbLogoUrl$path(logo2);
                                if (StringsKt.isBlank(p)) {
                                    str2 = tmdbAPI2;
                                    tmdbAPI3 = apiKey2;
                                } else {
                                    str2 = tmdbAPI2;
                                    tmdbAPI3 = apiKey2;
                                    l = StringsKt.trim(logo2.optString("iso_639_1")).toString().toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(l, "toLowerCase(...)");
                                    if (!Intrinsics.areEqual(l, lang)) {
                                        continue;
                                    } else {
                                        if (!fetchTmdbLogoUrl$isSvg(logo2)) {
                                            return fetchTmdbLogoUrl$urlOf(logo2);
                                        }
                                        if (svgFallback == null) {
                                            svgFallback = logo2;
                                        }
                                    }
                                }
                            }
                            i++;
                            apiKey2 = tmdbAPI3;
                            tmdbAPI2 = str2;
                        }
                        str = tmdbAPI2;
                        if (svgFallback != null) {
                            JSONObject it = svgFallback;
                            return fetchTmdbLogoUrl$urlOf(it);
                        }
                        best = null;
                        bestSvg = null;
                        length2 = logos.length();
                        for (i2 = 0; i2 < length2; i2++) {
                            logo = logos.optJSONObject(i2);
                            if (logo != null && fetchTmdbLogoUrl$voted(logo)) {
                                if (fetchTmdbLogoUrl$isSvg(logo)) {
                                    if (fetchTmdbLogoUrl$better(bestSvg, logo)) {
                                        bestSvg = logo;
                                    }
                                } else if (fetchTmdbLogoUrl$better(best, logo)) {
                                    best = logo;
                                }
                            }
                        }
                        if (best != null) {
                            JSONObject it2 = best;
                            return fetchTmdbLogoUrl$urlOf(it2);
                        }
                        if (bestSvg != null) {
                            return str;
                        }
                        JSONObject it3 = bestSvg;
                        return fetchTmdbLogoUrl$urlOf(it3);
                    } catch (Throwable th2) {
                        th = th2;
                        appLangCode2 = appLangCode;
                        apiKey2 = tmdbAPI;
                        Object $result3 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                        obj2 = obj;
                        if (Result.isFailure-impl(obj2)) {
                            obj2 = tmdbAPI2;
                        }
                        json = (JSONObject) obj2;
                        if (json != null) {
                            return tmdbAPI2;
                        }
                        if (appLangCode2 != null) {
                            lang = tmdbAPI2;
                        } else {
                            lang = tmdbAPI2;
                        }
                        svgFallback = null;
                        i = 0;
                        length = logos.length();
                        while (i < length) {
                            logo2 = logos.optJSONObject(i);
                            if (logo2 == null) {
                                str2 = tmdbAPI2;
                                tmdbAPI3 = apiKey2;
                            } else {
                                p = fetchTmdbLogoUrl$path(logo2);
                                if (StringsKt.isBlank(p)) {
                                    str2 = tmdbAPI2;
                                    tmdbAPI3 = apiKey2;
                                    l = StringsKt.trim(logo2.optString("iso_639_1")).toString().toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(l, "toLowerCase(...)");
                                    if (!Intrinsics.areEqual(l, lang)) {
                                        continue;
                                    } else {
                                        if (!fetchTmdbLogoUrl$isSvg(logo2)) {
                                            return fetchTmdbLogoUrl$urlOf(logo2);
                                        }
                                        if (svgFallback == null) {
                                            svgFallback = logo2;
                                        }
                                    }
                                } else {
                                    str2 = tmdbAPI2;
                                    tmdbAPI3 = apiKey2;
                                }
                            }
                            i++;
                            apiKey2 = tmdbAPI3;
                            tmdbAPI2 = str2;
                        }
                        str = tmdbAPI2;
                        if (svgFallback != null) {
                            JSONObject it4 = svgFallback;
                            return fetchTmdbLogoUrl$urlOf(it4);
                        }
                        best = null;
                        bestSvg = null;
                        length2 = logos.length();
                        while (i2 < length2) {
                            logo = logos.optJSONObject(i2);
                            if (logo != null) {
                                if (fetchTmdbLogoUrl$isSvg(logo)) {
                                    if (fetchTmdbLogoUrl$better(bestSvg, logo)) {
                                        bestSvg = logo;
                                    }
                                } else if (fetchTmdbLogoUrl$better(best, logo)) {
                                    best = logo;
                                }
                            }
                        }
                        if (best != null) {
                            JSONObject it5 = best;
                            return fetchTmdbLogoUrl$urlOf(it5);
                        }
                        if (bestSvg != null) {
                            return str;
                        }
                        JSONObject it6 = bestSvg;
                        return fetchTmdbLogoUrl$urlOf(it6);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    tmdbAPI2 = null;
                    appLangCode2 = appLangCode;
                    apiKey2 = tmdbAPI;
                }
                break;
            case 1:
                appLangCode2 = (String) c02752.L$4;
                String tmdbAPI4 = (String) c02752.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    apiKey2 = tmdbAPI4;
                    tmdbAPI2 = null;
                    obj = Result.constructor-impl(new JSONObject(((NiceResponse) $result).getText()));
                    break;
                } catch (Throwable th4) {
                    th = th4;
                    apiKey2 = tmdbAPI4;
                    tmdbAPI2 = null;
                    Object $result4 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                    obj2 = obj;
                    if (Result.isFailure-impl(obj2)) {
                        obj2 = tmdbAPI2;
                    }
                    json = (JSONObject) obj2;
                    if (json != null) {
                        return tmdbAPI2;
                    }
                    if (appLangCode2 != null) {
                        lang = tmdbAPI2;
                    } else {
                        lang = tmdbAPI2;
                    }
                    svgFallback = null;
                    i = 0;
                    length = logos.length();
                    while (i < length) {
                        logo2 = logos.optJSONObject(i);
                        if (logo2 == null) {
                            str2 = tmdbAPI2;
                            tmdbAPI3 = apiKey2;
                        } else {
                            p = fetchTmdbLogoUrl$path(logo2);
                            if (StringsKt.isBlank(p)) {
                                str2 = tmdbAPI2;
                                tmdbAPI3 = apiKey2;
                                l = StringsKt.trim(logo2.optString("iso_639_1")).toString().toLowerCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(l, "toLowerCase(...)");
                                if (!Intrinsics.areEqual(l, lang)) {
                                    continue;
                                } else {
                                    if (!fetchTmdbLogoUrl$isSvg(logo2)) {
                                        return fetchTmdbLogoUrl$urlOf(logo2);
                                    }
                                    if (svgFallback == null) {
                                        svgFallback = logo2;
                                    }
                                }
                            } else {
                                str2 = tmdbAPI2;
                                tmdbAPI3 = apiKey2;
                            }
                        }
                        i++;
                        apiKey2 = tmdbAPI3;
                        tmdbAPI2 = str2;
                    }
                    str = tmdbAPI2;
                    if (svgFallback != null) {
                        JSONObject it7 = svgFallback;
                        return fetchTmdbLogoUrl$urlOf(it7);
                    }
                    best = null;
                    bestSvg = null;
                    length2 = logos.length();
                    while (i2 < length2) {
                        logo = logos.optJSONObject(i2);
                        if (logo != null) {
                            if (fetchTmdbLogoUrl$isSvg(logo)) {
                                if (fetchTmdbLogoUrl$better(bestSvg, logo)) {
                                    bestSvg = logo;
                                }
                            } else if (fetchTmdbLogoUrl$better(best, logo)) {
                                best = logo;
                            }
                        }
                    }
                    if (best != null) {
                        JSONObject it8 = best;
                        return fetchTmdbLogoUrl$urlOf(it8);
                    }
                    if (bestSvg != null) {
                        return str;
                    }
                    JSONObject it9 = bestSvg;
                    return fetchTmdbLogoUrl$urlOf(it9);
                }
                obj2 = obj;
                if (Result.isFailure-impl(obj2)) {
                    obj2 = tmdbAPI2;
                }
                json = (JSONObject) obj2;
                if (json != null) {
                    return tmdbAPI2;
                }
                if (appLangCode2 != null) {
                    lang = tmdbAPI2;
                } else {
                    lang = tmdbAPI2;
                }
                svgFallback = null;
                i = 0;
                length = logos.length();
                while (i < length) {
                    logo2 = logos.optJSONObject(i);
                    if (logo2 == null) {
                        str2 = tmdbAPI2;
                        tmdbAPI3 = apiKey2;
                    } else {
                        p = fetchTmdbLogoUrl$path(logo2);
                        if (StringsKt.isBlank(p)) {
                            str2 = tmdbAPI2;
                            tmdbAPI3 = apiKey2;
                            l = StringsKt.trim(logo2.optString("iso_639_1")).toString().toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(l, "toLowerCase(...)");
                            if (!Intrinsics.areEqual(l, lang)) {
                                continue;
                            } else {
                                if (!fetchTmdbLogoUrl$isSvg(logo2)) {
                                    return fetchTmdbLogoUrl$urlOf(logo2);
                                }
                                if (svgFallback == null) {
                                    svgFallback = logo2;
                                }
                            }
                        } else {
                            str2 = tmdbAPI2;
                            tmdbAPI3 = apiKey2;
                        }
                    }
                    i++;
                    apiKey2 = tmdbAPI3;
                    tmdbAPI2 = str2;
                }
                str = tmdbAPI2;
                if (svgFallback != null) {
                    JSONObject it10 = svgFallback;
                    return fetchTmdbLogoUrl$urlOf(it10);
                }
                best = null;
                bestSvg = null;
                length2 = logos.length();
                while (i2 < length2) {
                    logo = logos.optJSONObject(i2);
                    if (logo != null) {
                        if (fetchTmdbLogoUrl$isSvg(logo)) {
                            if (fetchTmdbLogoUrl$better(bestSvg, logo)) {
                                bestSvg = logo;
                            }
                        } else if (fetchTmdbLogoUrl$better(best, logo)) {
                            best = logo;
                        }
                    }
                }
                if (best != null) {
                    JSONObject it11 = best;
                    return fetchTmdbLogoUrl$urlOf(it11);
                }
                if (bestSvg != null) {
                    return str;
                }
                JSONObject it12 = bestSvg;
                return fetchTmdbLogoUrl$urlOf(it12);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private static final String fetchTmdbLogoUrl$path(JSONObject o) {
        return o.optString("file_path");
    }

    private static final boolean fetchTmdbLogoUrl$isSvg(JSONObject o) {
        return StringsKt.endsWith(fetchTmdbLogoUrl$path(o), ".svg", true);
    }

    private static final String fetchTmdbLogoUrl$urlOf(JSONObject o) {
        return "https://image.tmdb.org/t/p/w500" + fetchTmdbLogoUrl$path(o);
    }

    private static final boolean fetchTmdbLogoUrl$voted(JSONObject o) {
        return o.optDouble("vote_average", 0.0d) > 0.0d && o.optInt("vote_count", 0) > 0;
    }

    private static final boolean fetchTmdbLogoUrl$better(JSONObject a, JSONObject b) {
        if (a == null) {
            return true;
        }
        double aAvg = a.optDouble("vote_average", 0.0d);
        int aCnt = a.optInt("vote_count", 0);
        double bAvg = b.optDouble("vote_average", 0.0d);
        int bCnt = b.optInt("vote_count", 0);
        if (bAvg <= aAvg) {
            return ((bAvg > aAvg ? 1 : (bAvg == aAvg ? 0 : -1)) == 0) && bCnt > aCnt;
        }
        return true;
    }

    @Nullable
    public static final String fixTitle(@Nullable String $this$fixTitle) {
        String strReplace$default;
        if ($this$fixTitle != null) {
            String strReplace = new Regex("[!%:']|( &)").replace($this$fixTitle, "");
            if (strReplace != null && (strReplace$default = StringsKt.replace$default(strReplace, " ", "-", false, 4, (Object) null)) != null) {
                String lowerCase = strReplace$default.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (lowerCase != null) {
                    return StringsKt.replace$default(lowerCase, "-–-", "-", false, 4, (Object) null);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0106  */
    /* JADX WARN: Code duplicated, block: B:28:0x010b  */
    /* JADX WARN: Code duplicated, block: B:39:0x0137  */
    /* JADX WARN: Code duplicated, block: B:42:0x01b3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Nullable
    public static final Object getHindMoviezLinks(@NotNull String source, @NotNull String url, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C02761 c02761;
        Object obj;
        char c;
        C02761 c02762;
        String source2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Object obj2;
        Object $result;
        Element elementSelectFirst;
        String string;
        String string2;
        Element elementSelectFirst2;
        Function1[] function1Arr;
        String strText;
        String strSubstringAfter$default;
        String strText2;
        String strSubstringAfter$default2;
        if (continuation instanceof C02761) {
            c02761 = (C02761) continuation;
            if ((c02761.label & Integer.MIN_VALUE) != 0) {
                c02761.label -= Integer.MIN_VALUE;
            } else {
                c02761 = new C02761(continuation);
            }
        } else {
            c02761 = new C02761(continuation);
        }
        Object $result2 = c02761.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c02761.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                Requests app = MainActivityKt.getApp();
                c02761.L$0 = source;
                c02761.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c02761.L$2 = function1;
                c02761.L$3 = function2;
                c02761.label = 1;
                C02761 c02763 = c02761;
                obj = coroutine_suspended;
                c = 1;
                Object obj3 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 10000L, (Interceptor) null, false, (ResponseParser) null, c02763, 3838, (Object) null);
                c02762 = c02763;
                if (obj3 == obj) {
                    return obj;
                }
                source2 = source;
                function3 = function1;
                function4 = function2;
                obj2 = obj3;
                $result = url;
                NiceResponse response = (NiceResponse) obj2;
                Document doc = response.getDocument();
                elementSelectFirst = doc.selectFirst("div.container p:contains(Name:)");
                string = null;
                if (elementSelectFirst != null || (strText2 = elementSelectFirst.text()) == null || (strSubstringAfter$default2 = StringsKt.substringAfter$default(strText2, "Name:", (String) null, 2, (Object) null)) == null) {
                    string2 = null;
                } else {
                    string2 = StringsKt.trim(strSubstringAfter$default2).toString();
                }
                if (string2 == null) {
                    string2 = "";
                }
                String name = string2;
                elementSelectFirst2 = doc.selectFirst("div.container p:contains(Size:)");
                if (elementSelectFirst2 != null && (strText = elementSelectFirst2.text()) != null && (strSubstringAfter$default = StringsKt.substringAfter$default(strText, "Size:", (String) null, 2, (Object) null)) != null) {
                    string = StringsKt.trim(strSubstringAfter$default).toString();
                }
                String fileSize = string != null ? string : "";
                String extractedSpecs = buildExtractedTitle(extractSpecs(name));
                int quality = getIndexQuality(name);
                function1Arr = new Function1[2];
                C02772 c02772 = new C02772(doc, source2, extractedSpecs, fileSize, function3, function4, response, quality, null);
                Function1<? super SubtitleFile, Unit> function5 = function3;
                Function1<? super ExtractorLink, Unit> function6 = function4;
                function1Arr[0] = c02772;
                String extractedSpecs2 = source2;
                String fileSize2 = fileSize;
                function1Arr[c] = new C02783(doc, function6, extractedSpecs2, extractedSpecs, fileSize2, quality, null);
                c02762.L$0 = SpillingKt.nullOutSpilledVariable(extractedSpecs2);
                c02762.L$1 = SpillingKt.nullOutSpilledVariable($result);
                c02762.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                c02762.L$3 = SpillingKt.nullOutSpilledVariable(function6);
                c02762.L$4 = SpillingKt.nullOutSpilledVariable(response);
                c02762.L$5 = SpillingKt.nullOutSpilledVariable(doc);
                c02762.L$6 = SpillingKt.nullOutSpilledVariable(name);
                c02762.L$7 = SpillingKt.nullOutSpilledVariable(fileSize2);
                c02762.L$8 = SpillingKt.nullOutSpilledVariable(extractedSpecs);
                c02762.I$0 = quality;
                c02762.label = 2;
                if (ParCollectionsKt.runAllAsync(function1Arr, c02762) == obj) {
                    return obj;
                }
                return Unit.INSTANCE;
            case 1:
                Function1<? super ExtractorLink, Unit> function7 = (Function1) c02761.L$3;
                Function1<? super SubtitleFile, Unit> function8 = (Function1) c02761.L$2;
                Object url2 = (String) c02761.L$1;
                String source3 = (String) c02761.L$0;
                ResultKt.throwOnFailure($result2);
                c02762 = c02761;
                obj = coroutine_suspended;
                function4 = function7;
                function3 = function8;
                source2 = source3;
                c = 1;
                obj2 = $result2;
                $result = url2;
                NiceResponse response2 = (NiceResponse) obj2;
                Document doc2 = response2.getDocument();
                elementSelectFirst = doc2.selectFirst("div.container p:contains(Name:)");
                string = null;
                if (elementSelectFirst != null) {
                    string2 = null;
                } else {
                    string2 = null;
                }
                if (string2 == null) {
                    string2 = "";
                }
                String name2 = string2;
                elementSelectFirst2 = doc2.selectFirst("div.container p:contains(Size:)");
                if (elementSelectFirst2 != null) {
                    string = StringsKt.trim(strSubstringAfter$default).toString();
                }
                if (string != null) {
                }
                String extractedSpecs3 = buildExtractedTitle(extractSpecs(name2));
                int quality2 = getIndexQuality(name2);
                function1Arr = new Function1[2];
                C02772 c02773 = new C02772(doc2, source2, extractedSpecs3, fileSize, function3, function4, response2, quality2, null);
                Function1<? super SubtitleFile, Unit> function9 = function3;
                Function1<? super ExtractorLink, Unit> function10 = function4;
                function1Arr[0] = c02773;
                String extractedSpecs4 = source2;
                String fileSize3 = fileSize;
                function1Arr[c] = new C02783(doc2, function10, extractedSpecs4, extractedSpecs3, fileSize3, quality2, null);
                c02762.L$0 = SpillingKt.nullOutSpilledVariable(extractedSpecs4);
                c02762.L$1 = SpillingKt.nullOutSpilledVariable($result);
                c02762.L$2 = SpillingKt.nullOutSpilledVariable(function9);
                c02762.L$3 = SpillingKt.nullOutSpilledVariable(function10);
                c02762.L$4 = SpillingKt.nullOutSpilledVariable(response2);
                c02762.L$5 = SpillingKt.nullOutSpilledVariable(doc2);
                c02762.L$6 = SpillingKt.nullOutSpilledVariable(name2);
                c02762.L$7 = SpillingKt.nullOutSpilledVariable(fileSize3);
                c02762.L$8 = SpillingKt.nullOutSpilledVariable(extractedSpecs3);
                c02762.I$0 = quality2;
                c02762.label = 2;
                if (ParCollectionsKt.runAllAsync(function1Arr, c02762) == obj) {
                    return obj;
                }
                return Unit.INSTANCE;
            case 2:
                int i = c02761.I$0;
                ResultKt.throwOnFailure($result2);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayUtilsKt$getHindMoviezLinks$2 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayUtilsKt$getHindMoviezLinks$2", f = "StreamPlayUtils.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {1462, 1471, 1482}, m = "invokeSuspend", n = {"redirectUrls", "$this$forEach$iv", "element$iv", "redirectUrl", "redirectUrls", "$this$forEach$iv", "element$iv", "redirectUrl", "redirectUrls", "$this$forEach$iv", "element$iv", "redirectUrl", "redirectDoc", "$this$forEach$iv", "element$iv", "btn", "href"}, nl = {1468, 1475, 1481}, s = {"L$0", "L$1", "L$9", "L$10", "L$0", "L$1", "L$9", "L$10", "L$0", "L$1", "L$9", "L$10", "L$11", "L$12", "L$14", "L$15", "L$16"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$getHindMoviezLinks$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2265:1\n1795#2,10:2266\n2068#2:2276\n2069#2:2279\n1805#2:2280\n2068#2:2281\n2068#2,2:2282\n2069#2:2284\n1#3:2277\n1#3:2278\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$getHindMoviezLinks$2\n*L\n1458#1:2266,10\n1458#1:2276\n1458#1:2279\n1458#1:2280\n1460#1:2281\n1477#1:2282,2\n1460#1:2284\n1458#1:2278\n*E\n"})
    static final class C02772 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Document $doc;
        final /* synthetic */ String $extractedSpecs;
        final /* synthetic */ String $fileSize;
        final /* synthetic */ int $quality;
        final /* synthetic */ NiceResponse $response;
        final /* synthetic */ String $source;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02772(Document document, String str, String str2, String str3, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, NiceResponse niceResponse, int i, Continuation<? super C02772> continuation) {
            super(1, continuation);
            this.$doc = document;
            this.$source = str;
            this.$extractedSpecs = str2;
            this.$fileSize = str3;
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$response = niceResponse;
            this.$quality = i;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C02772(this.$doc, this.$source, this.$extractedSpecs, this.$fileSize, this.$subtitleCallback, this.$callback, this.$response, this.$quality, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0198  */
        /* JADX WARN: Code duplicated, block: B:24:0x01c0  */
        /* JADX WARN: Code duplicated, block: B:26:0x0229 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:27:0x022a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x038b -> B:42:0x03a2). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x03b4 -> B:44:0x03c3). Please report as a decompilation issue!!! */
        /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
            java.lang.StackOverflowError
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
            */
        public final java.lang.Object invokeSuspend(java.lang.Object r41) {
            /*
                Method dump skipped, instruction units count: 1012
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.phisher98.StreamPlayUtilsKt.C02772.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayUtilsKt$getHindMoviezLinks$3 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayUtilsKt$getHindMoviezLinks$3", f = "StreamPlayUtils.kt", i = {0}, l = {1500}, m = "invokeSuspend", n = {"hCloudUrl"}, nl = {1499}, s = {"L$0"}, v = 2)
    static final class C02783 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Document $doc;
        final /* synthetic */ String $extractedSpecs;
        final /* synthetic */ String $fileSize;
        final /* synthetic */ int $quality;
        final /* synthetic */ String $source;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02783(Document document, Function1<? super ExtractorLink, Unit> function1, String str, String str2, String str3, int i, Continuation<? super C02783> continuation) {
            super(1, continuation);
            this.$doc = document;
            this.$callback = function1;
            this.$source = str;
            this.$extractedSpecs = str2;
            this.$fileSize = str3;
            this.$quality = i;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C02783(this.$doc, this.$callback, this.$source, this.$extractedSpecs, this.$fileSize, this.$quality, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String hCloudUrl;
            Object objNewExtractorLink;
            Function1<ExtractorLink, Unit> function1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Element elementSelectFirst = this.$doc.selectFirst("a.btn-dark");
                    if (elementSelectFirst == null || (hCloudUrl = elementSelectFirst.attr("href")) == null) {
                        return Unit.INSTANCE;
                    }
                    Function1<ExtractorLink, Unit> function2 = this.$callback;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(hCloudUrl);
                    this.L$1 = function2;
                    this.label = 1;
                    objNewExtractorLink = ExtractorApiKt.newExtractorLink(this.$source + "[HCloud]", this.$source + "[HCloud] " + this.$extractedSpecs + '[' + this.$fileSize + ']', hCloudUrl, ExtractorLinkType.VIDEO, new AnonymousClass1(this.$quality, null), (Continuation) this);
                    if (objNewExtractorLink == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function1 = function2;
                    break;
                    break;
                case 1:
                    function1 = (Function1) this.L$1;
                    ResultKt.throwOnFailure($result);
                    objNewExtractorLink = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function1.invoke(objNewExtractorLink);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.phisher98.StreamPlayUtilsKt$getHindMoviezLinks$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StreamPlayUtils.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.StreamPlayUtilsKt$getHindMoviezLinks$3$1", f = "StreamPlayUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $quality;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(int i, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$quality = i;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$quality, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
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
                        $this$newExtractorLink.setQuality(this.$quality);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    @NotNull
    public static final String buildExtractedTitle(@NotNull Map<String, ? extends List<String>> map) {
        Iterable $this$flatMap$iv = ORDERED_SPEC_CATEGORIES;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            String it = (String) element$iv$iv;
            Iterable iterableEmptyList = (List) map.get(it);
            if (iterableEmptyList == null) {
                iterableEmptyList = CollectionsKt.emptyList();
            }
            Iterable list$iv$iv = iterableEmptyList;
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        String specs = CollectionsKt.joinToString$default(CollectionsKt.distinct((List) destination$iv$iv), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        List<String> list = map.get("size");
        String size = list != null ? (String) CollectionsKt.firstOrNull(list) : null;
        if (size != null) {
            return specs + " [" + size + ']';
        }
        return specs;
    }

    @NotNull
    public static final Map<String, List<Map<String, String>>> getSPEC_OPTIONS() {
        return SPEC_OPTIONS;
    }

    @NotNull
    public static final Map<String, List<String>> extractSpecs(@NotNull final String inputString) {
        Map results = new LinkedHashMap();
        for (Map.Entry<String, List<Pair<String, Regex>>> entry : SPEC_REGEX_CACHE.entrySet()) {
            String category = entry.getKey();
            List matches = SequencesKt.toList(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(entry.getValue()), new Function1() { // from class: com.phisher98.StreamPlayUtilsKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(StreamPlayUtilsKt.extractSpecs$lambda$0$0(inputString, (Pair) obj));
                }
            }), new Function1() { // from class: com.phisher98.StreamPlayUtilsKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    return StreamPlayUtilsKt.extractSpecs$lambda$0$1((Pair) obj);
                }
            }));
            results.put(category, matches);
        }
        MatchResult sizeMatch = Regex.find$default(FILE_SIZE_REGEX, inputString, 0, 2, (Object) null);
        if (sizeMatch != null) {
            results.put("size", CollectionsKt.listOf(sizeMatch.getGroupValues().get(1)));
        }
        return MapsKt.toMap(results);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean extractSpecs$lambda$0$0(String $inputString, Pair pair) {
        Regex regex = (Regex) pair.component2();
        return regex.containsMatchIn($inputString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String extractSpecs$lambda$0$1(Pair pair) {
        String label = (String) pair.component1();
        return label;
    }

    private static final String getBROWSER_FINGERPRINT() {
        return (String) BROWSER_FINGERPRINT$delegate.getValue();
    }

    static final String BROWSER_FINGERPRINT_delegate$lambda$0() throws NoSuchAlgorithmException {
        String raw = CollectionsKt.joinToString$default(CollectionsKt.listOf(new String[]{"1920x1080x24", "Asia/Kolkata", "en-US", "Win32", "8", "8", "canvas_stub_xdmovies", "ANGLE (NVIDIA)", "no_touch", "3", "true", "unset"}), "|||", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = raw.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return StringsKt.take(ArraysKt.joinToString$default(messageDigest.digest(bytes), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StreamPlayUtilsKt$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                return StreamPlayUtilsKt.BROWSER_FINGERPRINT_delegate$lambda$0$0(((Byte) obj).byteValue());
            }
        }, 30, (Object) null), 32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence BROWSER_FINGERPRINT_delegate$lambda$0$0(byte it) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(it)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    @NotNull
    public static final String generateBrowserFingerprint() {
        return getBROWSER_FINGERPRINT();
    }

    /* JADX WARN: Code duplicated, block: B:107:0x07fb  */
    /* JADX WARN: Code duplicated, block: B:121:0x08f0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:122:0x08f1  */
    /* JADX WARN: Code duplicated, block: B:127:0x093f  */
    /* JADX WARN: Code duplicated, block: B:128:0x0942  */
    /* JADX WARN: Code duplicated, block: B:130:0x0946  */
    /* JADX WARN: Code duplicated, block: B:131:0x0947  */
    /* JADX WARN: Code duplicated, block: B:133:0x094a A[Catch: Exception -> 0x0968, TRY_LEAVE, TryCatch #19 {Exception -> 0x0968, blocks: (B:125:0x092d, B:133:0x094a), top: B:244:0x092d }] */
    /* JADX WARN: Code duplicated, block: B:158:0x0a48  */
    /* JADX WARN: Code duplicated, block: B:160:0x0ab5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:161:0x0ab6  */
    /* JADX WARN: Code duplicated, block: B:163:0x0af8  */
    /* JADX WARN: Code duplicated, block: B:164:0x0b21  */
    /* JADX WARN: Code duplicated, block: B:236:0x0803 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:161:0x0ab6 -> B:162:0x0ace). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:163:0x0af8 -> B:165:0x0b2d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:164:0x0b21 -> B:165:0x0b2d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object bypassXD(@org.jetbrains.annotations.NotNull java.lang.String r82, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.String> r83) {
        /*
            Method dump skipped, instruction units count: 3484
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.StreamPlayUtilsKt.bypassXD(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayUtilsKt$bypassXD$2 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayUtilsKt$bypassXD$2", f = "StreamPlayUtils.kt", i = {}, l = {1770}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C02722 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CompletableDeferred<Unit> $visibleTimeDone;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02722(CompletableDeferred<Unit> completableDeferred, Continuation<? super C02722> continuation) {
            super(2, continuation);
            this.$visibleTimeDone = completableDeferred;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C02722(this.$visibleTimeDone, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (this.$visibleTimeDone.await((Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:30:0x00e9 A[Catch: all -> 0x00d3, TRY_LEAVE, TryCatch #0 {all -> 0x00d3, blocks: (B:25:0x00ce, B:30:0x00e9), top: B:55:0x00ce }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:36:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:42:0x014c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x014d  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Nullable
    public static final Object safeGet(@NotNull String url, @Nullable Map<String, String> map, @Nullable String referer, @Nullable Long timeout, @Nullable Interceptor interceptor, boolean allowRedirects, int cacheTime, @NotNull Continuation<? super NiceResponse> continuation) throws Throwable {
        C02921 c02921;
        int $i$f$withPermit;
        Map<String, String> map2;
        String referer2;
        Interceptor interceptor2;
        int $i$f$withPermit2;
        String url2;
        Semaphore $this$withPermit$iv;
        boolean allowRedirects2;
        Long timeout2;
        boolean z;
        Map<String, String> mapEmptyMap;
        long jLongValue;
        Semaphore $this$withPermit$iv2;
        Object obj;
        if (continuation instanceof C02921) {
            c02921 = (C02921) continuation;
            if ((c02921.label & Integer.MIN_VALUE) != 0) {
                c02921.label -= Integer.MIN_VALUE;
            } else {
                c02921 = new C02921(continuation);
            }
        } else {
            c02921 = new C02921(continuation);
        }
        C02921 c02922 = c02921;
        Object $result = c02922.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c02922.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Semaphore $this$withPermit$iv3 = appGlobalSemaphore;
                c02922.L$0 = url;
                c02922.L$1 = map;
                c02922.L$2 = referer;
                c02922.L$3 = timeout;
                c02922.L$4 = interceptor;
                c02922.L$5 = $this$withPermit$iv3;
                c02922.Z$0 = allowRedirects;
                c02922.I$0 = cacheTime;
                c02922.label = 1;
                if ($this$withPermit$iv3.acquire(c02922) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $i$f$withPermit = 0;
                map2 = map;
                referer2 = referer;
                interceptor2 = interceptor;
                $i$f$withPermit2 = cacheTime;
                url2 = url;
                $this$withPermit$iv = $this$withPermit$iv3;
                allowRedirects2 = allowRedirects;
                timeout2 = timeout;
                z = true;
                try {
                    Requests app = MainActivityKt.getApp();
                    if (map2 == null) {
                        try {
                            mapEmptyMap = MapsKt.emptyMap();
                        } catch (Throwable th) {
                            th = th;
                            $this$withPermit$iv.release();
                            throw th;
                        }
                    } else {
                        mapEmptyMap = map2;
                    }
                    if (timeout2 != null) {
                        jLongValue = timeout2.longValue();
                    } else {
                        jLongValue = 10000;
                    }
                    if (!allowRedirects2) {
                        z = false;
                    }
                    c02922.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c02922.L$1 = SpillingKt.nullOutSpilledVariable(map2);
                    c02922.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                    c02922.L$3 = SpillingKt.nullOutSpilledVariable(timeout2);
                    c02922.L$4 = SpillingKt.nullOutSpilledVariable(interceptor2);
                    c02922.L$5 = $this$withPermit$iv;
                    c02922.Z$0 = allowRedirects2;
                    c02922.I$0 = $i$f$withPermit2;
                    c02922.label = 2;
                    $this$withPermit$iv2 = $this$withPermit$iv;
                    try {
                        obj = Requests.get$default(app, url2, mapEmptyMap, referer2, (Map) null, (Map) null, z, $i$f$withPermit2, (TimeUnit) null, jLongValue, interceptor2, false, (ResponseParser) null, c02922, 3224, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$withPermit$iv = $this$withPermit$iv2;
                        $result = obj;
                        try {
                            NiceResponse niceResponse = (NiceResponse) $result;
                            $this$withPermit$iv.release();
                            return niceResponse;
                        } catch (Throwable th2) {
                            th = th2;
                            $this$withPermit$iv.release();
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        $this$withPermit$iv = $this$withPermit$iv2;
                        $this$withPermit$iv.release();
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
                break;
                break;
            case 1:
                $i$f$withPermit2 = c02922.I$0;
                boolean allowRedirects3 = c02922.Z$0;
                Semaphore $this$withPermit$iv4 = (Semaphore) c02922.L$5;
                interceptor2 = (Interceptor) c02922.L$4;
                Long timeout3 = (Long) c02922.L$3;
                String referer3 = (String) c02922.L$2;
                Map<String, String> map3 = (Map) c02922.L$1;
                url2 = (String) c02922.L$0;
                ResultKt.throwOnFailure($result);
                $i$f$withPermit = 0;
                allowRedirects2 = allowRedirects3;
                $this$withPermit$iv = $this$withPermit$iv4;
                referer2 = referer3;
                map2 = map3;
                timeout2 = timeout3;
                z = true;
                Requests app2 = MainActivityKt.getApp();
                if (map2 == null) {
                    mapEmptyMap = MapsKt.emptyMap();
                } else {
                    mapEmptyMap = map2;
                }
                if (timeout2 != null) {
                    jLongValue = timeout2.longValue();
                    break;
                } else {
                    jLongValue = 10000;
                }
                if (!allowRedirects2) {
                    z = false;
                }
                c02922.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c02922.L$1 = SpillingKt.nullOutSpilledVariable(map2);
                c02922.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                c02922.L$3 = SpillingKt.nullOutSpilledVariable(timeout2);
                c02922.L$4 = SpillingKt.nullOutSpilledVariable(interceptor2);
                c02922.L$5 = $this$withPermit$iv;
                c02922.Z$0 = allowRedirects2;
                c02922.I$0 = $i$f$withPermit2;
                c02922.label = 2;
                $this$withPermit$iv2 = $this$withPermit$iv;
                obj = Requests.get$default(app2, url2, mapEmptyMap, referer2, (Map) null, (Map) null, z, $i$f$withPermit2, (TimeUnit) null, jLongValue, interceptor2, false, (ResponseParser) null, c02922, 3224, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this$withPermit$iv = $this$withPermit$iv2;
                $result = obj;
                NiceResponse niceResponse2 = (NiceResponse) $result;
                $this$withPermit$iv.release();
                return niceResponse2;
            case 2:
                int i = c02922.I$0;
                boolean z2 = c02922.Z$0;
                $this$withPermit$iv = (Semaphore) c02922.L$5;
                try {
                    ResultKt.throwOnFailure($result);
                    NiceResponse niceResponse3 = (NiceResponse) $result;
                    $this$withPermit$iv.release();
                    return niceResponse3;
                } catch (Throwable th5) {
                    th = th5;
                    $this$withPermit$iv.release();
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ Object safeGet$default(String str, Map map, String str2, Long l, Interceptor interceptor, boolean z, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            map = null;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        if ((i2 & 8) != 0) {
            l = null;
        }
        if ((i2 & 16) != 0) {
            interceptor = null;
        }
        if ((i2 & 32) != 0) {
            z = true;
        }
        if ((i2 & 64) != 0) {
            i = 0;
        }
        return safeGet(str, map, str2, l, interceptor, z, i, continuation);
    }

    @NotNull
    public static final List<Pair<String, String>> extractXpassBackups(@NotNull String html) throws JSONException {
        List groupValues;
        String raw;
        JSONArray array;
        Pair pair;
        MatchResult matchResultFind$default = Regex.find$default(new Regex("var backups=(\\[.*?]);", RegexOption.DOT_MATCHES_ALL), html, 0, 2, (Object) null);
        if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (raw = (String) groupValues.get(1)) == null) {
            return CollectionsKt.emptyList();
        }
        JSONArray array2 = new JSONArray(raw);
        Iterable $this$mapNotNull$iv = RangesKt.until(0, array2.length());
        Collection destination$iv$iv = new ArrayList();
        IntIterator it = $this$mapNotNull$iv.iterator();
        while (it.hasNext()) {
            int element$iv$iv$iv = it.nextInt();
            JSONObject obj = array2.getJSONObject(element$iv$iv$iv);
            String raw2 = raw;
            String name = obj.optString("name");
            if (StringsKt.isBlank(name)) {
                name = null;
            }
            if (name == null) {
                array = array2;
                pair = null;
            } else {
                array = array2;
                String url = obj.optString("url");
                if (StringsKt.isBlank(url)) {
                    url = null;
                }
                pair = url == null ? null : new Pair(name, url);
            }
            if (pair != null) {
                destination$iv$iv.add(pair);
            }
            raw = raw2;
            array2 = array;
            $this$mapNotNull$iv = $this$mapNotNull$iv;
        }
        return (List) destination$iv$iv;
    }

    @Nullable
    public static final String solvePowChallenge(@NotNull String challenge, int difficulty) throws NoSuchAlgorithmException {
        int maskBytes = difficulty / 8;
        int maskBits = difficulty % 8;
        int finalMask = maskBits > 0 ? (255 << (8 - maskBits)) & 255 : 0;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] challengeBytes = StringsKt.encodeToByteArray(challenge);
        byte[] buffer = new byte[challengeBytes.length + 16];
        ArraysKt.copyInto$default(challengeBytes, buffer, 0, 0, 0, 14, (Object) null);
        int challengeLen = challengeBytes.length;
        for (int nonce = 0; nonce < 10000000; nonce++) {
            String nonceStr = String.valueOf(nonce);
            byte[] nonceBytes = StringsKt.encodeToByteArray(nonceStr);
            ArraysKt.copyInto$default(nonceBytes, buffer, challengeLen, 0, 0, 12, (Object) null);
            int inputLen = nonceBytes.length + challengeLen;
            md.update(buffer, 0, inputLen);
            byte[] hash = md.digest();
            boolean ok = true;
            for (int i = 0; i < maskBytes; i++) {
                if (hash[i] != 0) {
                    ok = false;
                    break;
                }
            }
            if (ok && (finalMask == 0 || (hash[maskBytes] & finalMask) == 0)) {
                return nonceStr;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public static final <A, B> Object safeAmap(@NotNull Iterable<? extends A> iterable, int concurrency, @NotNull Function2<? super A, ? super Continuation<? super B>, ? extends Object> function2, @NotNull Continuation<? super Result<? extends List<? extends B>>> continuation) {
        C02911 c02911;
        Throwable th;
        Object objCoroutineScope;
        if (continuation instanceof C02911) {
            c02911 = (C02911) continuation;
            if ((c02911.label & Integer.MIN_VALUE) != 0) {
                c02911.label -= Integer.MIN_VALUE;
            } else {
                c02911 = new C02911(continuation);
            }
        } else {
            c02911 = new C02911(continuation);
        }
        Object $result = c02911.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c02911.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    Result.Companion companion = Result.Companion;
                    StreamPlayUtilsKt$safeAmap$2$1 streamPlayUtilsKt$safeAmap$2$1 = new StreamPlayUtilsKt$safeAmap$2$1(concurrency, iterable, function2, null);
                    c02911.L$0 = SpillingKt.nullOutSpilledVariable(iterable);
                    c02911.L$1 = SpillingKt.nullOutSpilledVariable(function2);
                    c02911.L$2 = SpillingKt.nullOutSpilledVariable(iterable);
                    c02911.I$0 = concurrency;
                    c02911.label = 1;
                    objCoroutineScope = CoroutineScopeKt.coroutineScope(streamPlayUtilsKt$safeAmap$2$1, c02911);
                    return objCoroutineScope == coroutine_suspended ? coroutine_suspended : Result.constructor-impl((List) objCoroutineScope);
                } catch (Throwable th2) {
                    th = th2;
                    Result.Companion companion2 = Result.Companion;
                    return Result.constructor-impl(ResultKt.createFailure(th));
                }
            case 1:
                int concurrency2 = c02911.I$0;
                try {
                    ResultKt.throwOnFailure($result);
                    objCoroutineScope = $result;
                } catch (Throwable th3) {
                    th = th3;
                    Result.Companion companion3 = Result.Companion;
                    return Result.constructor-impl(ResultKt.createFailure(th));
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ Object safeAmap$default(Iterable $this$safeAmap_u24default, int concurrency, Function2 f, Continuation $completion, int i, Object obj) {
        if ((i & 1) != 0) {
            concurrency = 7;
        }
        try {
            Result.Companion companion = Result.Companion;
            return Result.constructor-impl((List) CoroutineScopeKt.coroutineScope(new StreamPlayUtilsKt$safeAmap$2$1(concurrency, $this$safeAmap_u24default, f, null), (Continuation) null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            return Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    private static final <A, B> Object safeAmap$$forInline(Iterable<? extends A> iterable, int concurrency, Function2<? super A, ? super Continuation<? super B>, ? extends Object> function2, Continuation<? super Result<? extends List<? extends B>>> continuation) {
        try {
            Result.Companion companion = Result.Companion;
            return Result.constructor-impl((List) CoroutineScopeKt.coroutineScope(new StreamPlayUtilsKt$safeAmap$2$1(concurrency, iterable, function2, null), (Continuation) null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            return Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    @NotNull
    public static final String hindmoviezbase64Url(@NotNull String input) {
        byte[] bytes = input.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(MainAPIKt.base64Encode(bytes), "+", "-", false, 4, (Object) null), "/", "_", false, 4, (Object) null), "=", "", false, 4, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:121:0x0251 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:127:0x01ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:135:0x0214 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x0194  */
    /* JADX WARN: Code duplicated, block: B:44:0x019b  */
    /* JADX WARN: Code duplicated, block: B:51:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:66:0x020d  */
    /* JADX WARN: Code duplicated, block: B:76:0x0229 A[Catch: Exception -> 0x0242, TRY_LEAVE, TryCatch #14 {Exception -> 0x0242, blocks: (B:64:0x0207, B:67:0x020e, B:76:0x0229, B:75:0x0223, B:63:0x01fd, B:70:0x0214), top: B:134:0x01fd, inners: #15 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:89:0x0257 A[Catch: Exception -> 0x025e, TRY_LEAVE, TryCatch #6 {Exception -> 0x025e, blocks: (B:87:0x0251, B:89:0x0257), top: B:121:0x0251 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0264 A[Catch: Exception -> 0x0280, TRY_ENTER, TRY_LEAVE, TryCatch #4 {Exception -> 0x0280, blocks: (B:85:0x024b, B:94:0x0264), top: B:117:0x024b }] */
    @Nullable
    public static final Object hindmoviezsignHShare(@NotNull String rawId, @NotNull String domain, @NotNull Document pageDoc, @NotNull Continuation<? super String> continuation) {
        C02801 c02801;
        String str;
        String domain2;
        String encoded;
        String str2;
        String str3;
        String ajaxUrl;
        List groupValues;
        String it;
        String ajaxUrl2;
        Object obj;
        Object objDecodeFromString;
        Object obj2;
        String ajaxUrl3;
        DeserializationStrategy deserializationStrategy;
        StreamPlayHindmoviezSignResponse response;
        StreamPlayHindmoviezSignData data;
        String url;
        if (continuation instanceof C02801) {
            c02801 = (C02801) continuation;
            if ((c02801.label & Integer.MIN_VALUE) != 0) {
                c02801.label -= Integer.MIN_VALUE;
            } else {
                c02801 = new C02801(continuation);
            }
        } else {
            c02801 = new C02801(continuation);
        }
        C02801 c02802 = c02801;
        Object $result = c02802.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c02802.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String encoded2 = hindmoviezbase64Url(rawId);
                Iterable $this$mapNotNull$iv = pageDoc.select("script");
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    Element script = (Element) element$iv$iv$iv;
                    Object $result2 = $result;
                    Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                    MatchResult matchResultFind$default = Regex.find$default(new Regex("AJAX_URL\\s*=\\s*['\"]([^'\"]+)['\"]"), script.html(), 0, 2, (Object) null);
                    String str4 = (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null) ? null : (String) groupValues.get(1);
                    if (str4 != null) {
                        destination$iv$iv.add(str4);
                    }
                    $result = $result2;
                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                }
                String ajaxUrl4 = (String) CollectionsKt.firstOrNull((List) destination$iv$iv);
                if (ajaxUrl4 == null) {
                    return domain + "/dl/" + encoded2;
                }
                try {
                    Requests app = MainActivityKt.getApp();
                    Map mapMapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("action", "hindshare_sign"), TuplesKt.to("d", encoded2)});
                    c02802.L$0 = SpillingKt.nullOutSpilledVariable(rawId);
                    c02802.L$1 = domain;
                    c02802.L$2 = SpillingKt.nullOutSpilledVariable(pageDoc);
                    c02802.L$3 = encoded2;
                    c02802.L$4 = SpillingKt.nullOutSpilledVariable(ajaxUrl4);
                    c02802.label = 1;
                    str2 = null;
                    str3 = "/dl/";
                    try {
                        Object objPost$default = Requests.post$default(app, ajaxUrl4, (Map) null, (String) null, (Map) null, (Map) null, mapMapOf, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c02802, 65502, (Object) null);
                        if (objPost$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ajaxUrl = ajaxUrl4;
                        encoded = encoded2;
                        $result = objPost$default;
                        domain2 = domain;
                        try {
                            it = ((NiceResponse) $result).getText();
                            AppUtils appUtils = AppUtils.INSTANCE;
                            if (it != null) {
                                obj2 = str2;
                                ajaxUrl2 = ajaxUrl;
                            } else {
                                try {
                                    try {
                                        Result.Companion companion = Result.Companion;
                                        KType kTypeTypeOf = Reflection.typeOf(StreamPlayHindmoviezSignResponse.class);
                                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                    } catch (Throwable th) {
                                        Result.Companion companion2 = Result.Companion;
                                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                                    }
                                    if (Result.exceptionOrNull-impl(obj) != null) {
                                        ajaxUrl2 = ajaxUrl;
                                        ajaxUrl3 = str2;
                                    } else {
                                        try {
                                            Result.Companion companion3 = Result.Companion;
                                            try {
                                                ajaxUrl2 = ajaxUrl;
                                                ajaxUrl3 = null;
                                                try {
                                                    obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(StreamPlayHindmoviezSignResponse.class), (List) null, 2, (Object) null));
                                                    break;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    try {
                                                        Result.Companion companion4 = Result.Companion;
                                                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                                                    } catch (Exception e) {
                                                        objDecodeFromString = null;
                                                    }
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                ajaxUrl2 = ajaxUrl;
                                                ajaxUrl3 = null;
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            ajaxUrl2 = ajaxUrl;
                                            ajaxUrl3 = str2;
                                        }
                                    }
                                    if (Result.isFailure-impl(obj)) {
                                        obj = ajaxUrl3;
                                    }
                                    deserializationStrategy = (KSerializer) obj;
                                    if (deserializationStrategy != null) {
                                        try {
                                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, it);
                                        } catch (SerializationException e2) {
                                            ArchComponentExtKt.logError(e2);
                                            ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                            objDecodeFromString = $this$readValue$iv$iv$iv.readValue(it, new TypeReference<StreamPlayHindmoviezSignResponse>() { // from class: com.phisher98.StreamPlayUtilsKt$hindmoviezsignHShare$lambda$1$$inlined$tryParseJson$1
                                            });
                                        } catch (Throwable th5) {
                                            ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                            objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(it, new TypeReference<StreamPlayHindmoviezSignResponse>() { // from class: com.phisher98.StreamPlayUtilsKt$hindmoviezsignHShare$lambda$1$$inlined$tryParseJson$1
                                            });
                                        }
                                    } else {
                                        ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                                        objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(it, new TypeReference<StreamPlayHindmoviezSignResponse>() { // from class: com.phisher98.StreamPlayUtilsKt$hindmoviezsignHShare$lambda$1$$inlined$tryParseJson$1
                                        });
                                    }
                                } catch (Exception e3) {
                                    ajaxUrl2 = ajaxUrl;
                                    objDecodeFromString = null;
                                    obj2 = objDecodeFromString;
                                    response = (StreamPlayHindmoviezSignResponse) obj2;
                                    if (response != null) {
                                        try {
                                            data = response.getData();
                                            if (data == null) {
                                                str = str3;
                                                url = domain2 + str + encoded;
                                            } else {
                                                str = str3;
                                                try {
                                                    url = domain2 + str + encoded;
                                                } catch (Exception e4) {
                                                    return domain2 + str + encoded;
                                                }
                                            }
                                        } catch (Exception e5) {
                                            str = str3;
                                            return domain2 + str + encoded;
                                        }
                                        break;
                                    } else {
                                        str = str3;
                                        url = domain2 + str + encoded;
                                        break;
                                    }
                                    return url;
                                }
                                obj2 = objDecodeFromString;
                            }
                            try {
                                response = (StreamPlayHindmoviezSignResponse) obj2;
                                if (response != null) {
                                    str = str3;
                                    url = domain2 + str + encoded;
                                    break;
                                } else {
                                    data = response.getData();
                                    if (data == null || (url = data.getUrl()) == null) {
                                        str = str3;
                                        url = domain2 + str + encoded;
                                    }
                                    break;
                                }
                                return url;
                            } catch (Exception e6) {
                                str = str3;
                            }
                        } catch (Exception e7) {
                            str = str3;
                        }
                    } catch (Exception e8) {
                        str = str3;
                        domain2 = domain;
                        encoded = encoded2;
                        return domain2 + str + encoded;
                    }
                } catch (Exception e9) {
                    str = "/dl/";
                    domain2 = domain;
                    encoded = encoded2;
                }
                break;
                break;
            case 1:
                ajaxUrl = (String) c02802.L$4;
                encoded = (String) c02802.L$3;
                String domain3 = (String) c02802.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    str3 = "/dl/";
                    str2 = null;
                    domain2 = domain3;
                    it = ((NiceResponse) $result).getText();
                    AppUtils appUtils2 = AppUtils.INSTANCE;
                    if (it != null) {
                        Result.Companion companion5 = Result.Companion;
                        KType kTypeTypeOf2 = Reflection.typeOf(StreamPlayHindmoviezSignResponse.class);
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                        if (Result.exceptionOrNull-impl(obj) != null) {
                            Result.Companion companion6 = Result.Companion;
                            ajaxUrl2 = ajaxUrl;
                            ajaxUrl3 = null;
                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(StreamPlayHindmoviezSignResponse.class), (List) null, 2, (Object) null));
                        } else {
                            ajaxUrl2 = ajaxUrl;
                            ajaxUrl3 = str2;
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = ajaxUrl3;
                        }
                        deserializationStrategy = (KSerializer) obj;
                        if (deserializationStrategy != null) {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, it);
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(it, new TypeReference<StreamPlayHindmoviezSignResponse>() { // from class: com.phisher98.StreamPlayUtilsKt$hindmoviezsignHShare$lambda$1$$inlined$tryParseJson$1
                            });
                        }
                        obj2 = objDecodeFromString;
                        break;
                    } else {
                        obj2 = str2;
                        ajaxUrl2 = ajaxUrl;
                    }
                    response = (StreamPlayHindmoviezSignResponse) obj2;
                    if (response != null) {
                        str = str3;
                        url = domain2 + str + encoded;
                        break;
                    } else {
                        data = response.getData();
                        if (data == null) {
                            str = str3;
                            url = domain2 + str + encoded;
                        } else {
                            str = str3;
                            url = domain2 + str + encoded;
                        }
                        break;
                    }
                    return url;
                } catch (Exception e10) {
                    str = "/dl/";
                    domain2 = domain3;
                    return domain2 + str + encoded;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @NotNull
    public static final JSONArray cinemacityparseSubtitles(@Nullable String raw) throws JSONException {
        JSONArray tracks = new JSONArray();
        String str = raw;
        if (str == null || StringsKt.isBlank(str)) {
            return tracks;
        }
        Iterable $this$forEach$iv = StringsKt.split$default(raw, new String[]{","}, false, 0, 6, (Object) null);
        for (Object element$iv : $this$forEach$iv) {
            String entry = (String) element$iv;
            MatchResult match = Regex.find$default(new Regex("\\[(.+?)](https?://.+)"), StringsKt.trim(entry).toString(), 0, 2, (Object) null);
            if (match != null) {
                JSONObject $this$cinemacityparseSubtitles_u24lambda_u240_u240 = new JSONObject();
                $this$cinemacityparseSubtitles_u24lambda_u240_u240.put("language", match.getGroupValues().get(1));
                $this$cinemacityparseSubtitles_u24lambda_u240_u240.put("subtitleUrl", match.getGroupValues().get(2));
                tracks.put($this$cinemacityparseSubtitles_u24lambda_u240_u240);
            }
        }
        return tracks;
    }

    public static /* synthetic */ List cinemacitybuildDownloadLinks$default(String str, JSONArray jSONArray, int i, String str2, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            num = null;
        }
        if ((i2 & 32) != 0) {
            num2 = null;
        }
        return cinemacitybuildDownloadLinks(str, jSONArray, i, str2, num, num2);
    }

    @NotNull
    public static final List<Triple<String, Integer, String>> cinemacitybuildDownloadLinks(@NotNull String base, @Nullable JSONArray subtitles, int selectedAudioIndex, @NotNull String title, @Nullable Integer season, @Nullable Integer episode) {
        String audio;
        String name;
        Iterable $this$map$iv = StringsKt.split$default(base, new String[]{","}, false, 0, 6, (Object) null);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(StringsKt.trim(it).toString());
        }
        List parts = (List) destination$iv$iv;
        List $this$filter$iv = parts;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            String it2 = (String) element$iv$iv;
            if (StringsKt.endsWith$default(it2, ".mp4", false, 2, (Object) null)) {
                destination$iv$iv2.add(element$iv$iv);
            }
        }
        List<String> videoFiles = (List) destination$iv$iv2;
        List $this$filter$iv2 = parts;
        Collection destination$iv$iv3 = new ArrayList();
        for (Object element$iv$iv2 : $this$filter$iv2) {
            String it3 = (String) element$iv$iv2;
            if (StringsKt.endsWith$default(it3, ".m4a", false, 2, (Object) null)) {
                destination$iv$iv3.add(element$iv$iv2);
            }
        }
        List audioFiles = (List) destination$iv$iv3;
        if (!audioFiles.isEmpty() && (audio = (String) CollectionsKt.getOrNull(audioFiles, selectedAudioIndex)) != null) {
            String baseUrl = CollectionsKt.joinToString$default(parts, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            String langRaw = StringsKt.substringBefore$default(StringsKt.substringAfterLast$default(audio, "_", (String) null, 2, (Object) null), ".m4a", (String) null, 2, (Object) null);
            String strReplace$default = StringsKt.replace$default(langRaw, "-", " ", false, 4, (Object) null);
            if (strReplace$default.length() > 0) {
                StringBuilder sb = new StringBuilder();
                char it4 = strReplace$default.charAt(0);
                String strValueOf = String.valueOf(it4);
                Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
                String upperCase = strValueOf.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                StringBuilder sbAppend = sb.append((Object) upperCase);
                String strSubstring = strReplace$default.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                strReplace$default = sbAppend.append(strSubstring).toString();
            }
            String lang = strReplace$default;
            List results = new ArrayList();
            for (String video : videoFiles) {
                int quality = cinemacityextractQuality(video);
                String res = StringsKt.substringBefore$default(StringsKt.substringAfterLast$default(video, "_", (String) null, 2, (Object) null), ".mp4", (String) null, 2, (Object) null);
                if (season != null && episode != null) {
                    name = cinemacitybuildDownloadLinks$cleanTitle(title) + ".S" + season.intValue() + 'E' + episode.intValue() + '.' + res + '.' + StringsKt.replace$default(lang, " ", ".", false, 4, (Object) null);
                } else {
                    name = cinemacitybuildDownloadLinks$cleanTitle(title) + '.' + res + '.' + StringsKt.replace$default(lang, " ", ".", false, 4, (Object) null);
                }
                List parts2 = parts;
                String subs = cinemacitybuildDownloadLinks$filterSubs(subtitles, video);
                List videoFiles2 = videoFiles;
                String finalUrl = cinemacitymakeDownloadHref(baseUrl, video, audio, subs, name);
                results.add(new Triple(finalUrl, Integer.valueOf(quality), lang));
                parts = parts2;
                videoFiles = videoFiles2;
                audio = audio;
                audioFiles = audioFiles;
                lang = lang;
            }
            return results;
        }
        return CollectionsKt.emptyList();
    }

    private static final String cinemacitybuildDownloadLinks$normalizeSubtitle(String url) {
        int idx = StringsKt.indexOf$default(url, "/public_files/", 0, false, 6, (Object) null);
        if (idx == -1) {
            return null;
        }
        String strSubstring = url.substring("/public_files/".length() + idx);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    private static final String cinemacitybuildDownloadLinks$filterSubs(JSONArray $subtitles, String video) {
        String it;
        String baseName = StringsKt.substringBefore$default(StringsKt.substringBefore$default(StringsKt.substringAfterLast$default(video, "/", (String) null, 2, (Object) null), "_web-dl", (String) null, 2, (Object) null), "_202", (String) null, 2, (Object) null);
        if ($subtitles != null) {
            Iterable $this$mapNotNull$iv = RangesKt.until(0, $subtitles.length());
            Collection destination$iv$iv = new ArrayList();
            IntIterator it2 = $this$mapNotNull$iv.iterator();
            while (it2.hasNext()) {
                int element$iv$iv$iv = it2.nextInt();
                JSONObject jSONObjectOptJSONObject = $subtitles.optJSONObject(element$iv$iv$iv);
                String it3 = (jSONObjectOptJSONObject == null || (it = jSONObjectOptJSONObject.optString("subtitleUrl")) == null) ? null : cinemacitybuildDownloadLinks$normalizeSubtitle(it);
                if (it3 != null) {
                    destination$iv$iv.add(it3);
                }
            }
            Iterable $this$filter$iv = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                String baseName2 = baseName;
                Iterable $this$filter$iv2 = $this$filter$iv;
                if (StringsKt.contains$default((String) element$iv$iv, baseName, false, 2, (Object) null)) {
                    destination$iv$iv2.add(element$iv$iv);
                }
                baseName = baseName2;
                $this$filter$iv = $this$filter$iv2;
            }
            String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.distinct((List) destination$iv$iv2), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            if (strJoinToString$default != null) {
                return strJoinToString$default;
            }
        }
        return "";
    }

    private static final String cinemacitybuildDownloadLinks$cleanTitle(String input) {
        return StringsKt.trim(new Regex("\\.+").replace(new Regex("[\\s_]+").replace(new Regex("[^0-9A-Za-z\\s._-]").replace(input, ""), "."), "."), new char[]{'.'});
    }

    @NotNull
    public static final String cinemacitymakeDownloadHref(@NotNull String base, @NotNull String videoPath, @NotNull String audioPath, @Nullable String subtitlePaths, @NotNull String name) {
        StringBuilder $this$cinemacitymakeDownloadHref_u24lambda_u240 = new StringBuilder();
        $this$cinemacitymakeDownloadHref_u24lambda_u240.append("?action=download");
        $this$cinemacitymakeDownloadHref_u24lambda_u240.append("&video=" + URLEncoder.encode(videoPath, "UTF-8"));
        $this$cinemacitymakeDownloadHref_u24lambda_u240.append("&audio=" + URLEncoder.encode(audioPath, "UTF-8"));
        String str = subtitlePaths;
        if (!(str == null || str.length() == 0)) {
            $this$cinemacitymakeDownloadHref_u24lambda_u240.append("&subtitle=" + URLEncoder.encode(subtitlePaths, "UTF-8"));
        }
        $this$cinemacitymakeDownloadHref_u24lambda_u240.append("&name=" + URLEncoder.encode(name, "UTF-8"));
        String qs = $this$cinemacitymakeDownloadHref_u24lambda_u240.toString();
        return base + qs;
    }

    public static final int cinemacityextractQuality(@NotNull String url) {
        if (StringsKt.contains$default(url, "2160p", false, 2, (Object) null)) {
            return Qualities.P2160.getValue();
        }
        if (StringsKt.contains$default(url, "1440p", false, 2, (Object) null)) {
            return Qualities.P1440.getValue();
        }
        if (StringsKt.contains$default(url, "1080p", false, 2, (Object) null)) {
            return Qualities.P1080.getValue();
        }
        if (StringsKt.contains$default(url, "720p", false, 2, (Object) null)) {
            return Qualities.P720.getValue();
        }
        if (StringsKt.contains$default(url, "480p", false, 2, (Object) null)) {
            return Qualities.P480.getValue();
        }
        return StringsKt.contains$default(url, "360p", false, 2, (Object) null) ? Qualities.P360.getValue() : Qualities.Unknown.getValue();
    }

    @NotNull
    public static final String moviesdrivebase64Decode(@NotNull String input) {
        String normalized;
        try {
            String it = StringsKt.replace$default(StringsKt.replace$default(input, '-', '+', false, 4, (Object) null), '_', '/', false, 4, (Object) null);
            switch (it.length() % 4) {
                case 2:
                    normalized = it + "==";
                    break;
                case 3:
                    normalized = it + '=';
                    break;
                default:
                    normalized = it;
                    break;
            }
            byte[] decoded = MainAPIKt.base64DecodeArray(normalized);
            return new String(decoded, StandardCharsets.UTF_8);
        } catch (Exception e) {
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0095  */
    /* JADX WARN: Code duplicated, block: B:28:0x00af A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:40:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:42:0x0102  */
    /* JADX WARN: Code duplicated, block: B:44:0x0104  */
    /* JADX WARN: Code duplicated, block: B:46:0x0123 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x0124  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0124 -> B:48:0x0130). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Object retry(int r20, long r21, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r23, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r24) {
        /*
            Method dump skipped, instruction units count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.StreamPlayUtilsKt.retry(int, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object retry$default(int i, long j, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 3;
        }
        if ((i2 & 2) != 0) {
            j = 1000;
        }
        return retry(i, j, function1, continuation);
    }

    @Nullable
    public static final String peachifyDecrypt(@NotNull String encrypt) {
        try {
            List parts = StringsKt.split$default(encrypt, new String[]{"."}, false, 0, 6, (Object) null);
            if (parts.size() != 3) {
                return null;
            }
            byte[] iv = b64UrlDecode((String) parts.get(0));
            byte[] cipherText = ArraysKt.plus(b64UrlDecode((String) parts.get(1)), b64UrlDecode((String) parts.get(2)));
            Iterable $this$map$iv = StringsKt.chunked("a8f2a1b5e9c470814f6b2c3a5d8e7f9c1a2b3c4d5e3f7a8b8cad1e2d0a4d5c5b", 2);
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                String it = (String) item$iv$iv;
                destination$iv$iv.add(Byte.valueOf((byte) Integer.parseInt(it, CharsKt.checkRadix(16))));
            }
            byte[] keyBytes = CollectionsKt.toByteArray((List) destination$iv$iv);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, new SecretKeySpec(keyBytes, "AES"), new GCMParameterSpec(128, iv));
            return new String(cipher.doFinal(cipherText), Charsets.UTF_8);
        } catch (Exception e) {
            Log.INSTANCE.e("Peachify", "Decrypt failed");
            return null;
        }
    }

    @NotNull
    public static final byte[] b64UrlDecode(@NotNull String data) {
        String it = StringsKt.replace$default(StringsKt.replace$default(data, '-', '+', false, 4, (Object) null), '_', '/', false, 4, (Object) null);
        String fixed = it + StringsKt.repeat("=", (4 - (it.length() % 4)) % 4);
        return MainAPIKt.base64DecodeArray(fixed);
    }

    @Nullable
    public static final String decodeToBeParsed(@NotNull String encoded) {
        try {
            byte[] raw = MainAPIKt.base64DecodeArray(encoded);
            if (raw.length < 29) {
                return null;
            }
            byte[] iv = ArraysKt.copyOfRange(raw, 1, 13);
            byte[] ctr = new byte[16];
            System.arraycopy(iv, 0, ctr, 0, iv.length);
            ctr[15] = 2;
            byte[] ciphertext = ArraysKt.copyOfRange(raw, 13, raw.length - 16);
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = "Xot36i3lK3:v1".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] key = messageDigest.digest(bytes);
            Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
            cipher.init(2, new SecretKeySpec(key, "AES"), new IvParameterSpec(ctr));
            return new String(cipher.doFinal(ciphertext), Charsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    public static final String decryptVidrockUrl(@NotNull String encryptedPayload) {
        try {
            Iterable $this$map$iv = StringsKt.chunked("7f3e9c2a8b5d1f4e6a9c3b7d2e5f8a1c4b6d9e2f5a8c1b4d7e9f2a5c8b1d4e7f", 2);
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                try {
                    String it = (String) item$iv$iv;
                    destination$iv$iv.add(Byte.valueOf((byte) Integer.parseInt(it, CharsKt.checkRadix(16))));
                } catch (Exception e) {
                    Log.INSTANCE.e("Vidrock", "Decryption failed");
                    return null;
                }
            }
            byte[] keyBytes = CollectionsKt.toByteArray((List) destination$iv$iv);
            try {
                String standardBase64 = StringsKt.replace$default(StringsKt.replace$default(encryptedPayload, "-", "+", false, 4, (Object) null), "_", "/", false, 4, (Object) null);
                while (standardBase64.length() % 4 != 0) {
                    standardBase64 = standardBase64 + '=';
                }
                byte[] encryptedData = MainAPIKt.base64DecodeArray(standardBase64);
                byte[] nonce = ArraysKt.copyOfRange(encryptedData, 0, 12);
                byte[] cipherTextWithTag = ArraysKt.copyOfRange(encryptedData, 12, encryptedData.length);
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
                GCMParameterSpec gcmSpec = new GCMParameterSpec(128, nonce);
                cipher.init(2, keySpec, gcmSpec);
                byte[] decryptedBytes = cipher.doFinal(cipherTextWithTag);
                return new String(decryptedBytes, Charsets.UTF_8);
            } catch (Exception e2) {
                Log.INSTANCE.e("Vidrock", "Decryption failed");
                return null;
            }
        } catch (Exception e3) {
        }
    }

    @NotNull
    public static final String goatedGenerateRandomIP() {
        Random random = new Random();
        int first = goatedGenerateRandomIP$p(random);
        while (CollectionsKt.listOf(new Integer[]{0, 10, 127, 169, 172, 192}).contains(Integer.valueOf(first))) {
            first = goatedGenerateRandomIP$p(random);
        }
        return new StringBuilder().append(first).append('.').append(goatedGenerateRandomIP$p(random)).append('.').append(goatedGenerateRandomIP$p(random)).append('.').append(goatedGenerateRandomIP$p(random)).toString();
    }

    private static final int goatedGenerateRandomIP$p(Random random) {
        return random.nextInt(256);
    }

    @NotNull
    public static final byte[] goatedDeriveKey(@NotNull String tokenString, @NotNull byte[] salt, @NotNull byte[] info) throws NoSuchAlgorithmException, InvalidKeyException {
        byte[] rawKey = StringsKt.encodeToByteArray(tokenString);
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(salt, "HmacSHA256"));
        byte[] prk = mac.doFinal(rawKey);
        mac.init(new SecretKeySpec(prk, "HmacSHA256"));
        mac.update(info);
        mac.update((byte) 1);
        return mac.doFinal();
    }

    @NotNull
    public static final String goatedEncryptParams(@NotNull String payloadStr, @NotNull byte[] key) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] iv = new byte[12];
        new SecureRandom().nextBytes(iv);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, new SecretKeySpec(key, "AES"), new GCMParameterSpec(128, iv));
        byte[] ct = cipher.doFinal(StringsKt.encodeToByteArray(payloadStr));
        return MainAPIKt.base64Encode(ArraysKt.plus(iv, ct));
    }

    @Nullable
    public static final String goatedDecryptUrl(@NotNull String b64Url, @NotNull byte[] key) {
        try {
            byte[] raw = MainAPIKt.base64DecodeArray(b64Url);
            byte[] iv = ArraysKt.copyOfRange(raw, 0, 12);
            byte[] ct = ArraysKt.copyOfRange(raw, 12, raw.length);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, new SecretKeySpec(key, "AES"), new GCMParameterSpec(128, iv));
            return StringsKt.decodeToString(cipher.doFinal(ct));
        } catch (Exception e) {
            return null;
        }
    }
}
