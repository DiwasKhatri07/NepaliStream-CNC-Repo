package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\bq\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bã\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b,\u0010-J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jå\u0003\u0010u\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0018\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010v\u001a\u00020w2\b\u0010x\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010y\u001a\u00020zHÖ\u0081\u0004J\n\u0010{\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010/R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010/R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010/R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010/R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010/R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010/R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010/R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010/R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010/R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010/R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010/R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010/R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010/R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010/R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010/R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010/R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010/R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010/R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010/R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010/R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u0010/R\u0013\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u0010/R\u0013\u0010!\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u0010/R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bH\u0010/R\u0013\u0010#\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bI\u0010/R\u0013\u0010$\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010/R\u0013\u0010%\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u0010/R\u0013\u0010&\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u0010/R\u0013\u0010'\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bM\u0010/R\u0013\u0010(\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bN\u0010/R\u0013\u0010)\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bO\u0010/R\u0013\u0010*\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bP\u0010/R\u0013\u0010+\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010/¨\u0006|"}, d2 = {"Lcom/phisher98/DomainsParser;", "", "moviesdrive", "", "hdhub4u", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "HDHUB4u", "n4khdhub", "4khdhub", "multiMovies", "MultiMovies", "bollyflix", "uhdmovies", "UHDMovies", "moviesmod", "topMovies", "hdmovie2", "vegamovies", "rogmovies", "luxmovies", "movierulzhd", "extramovies", "banglaplex", "toonstream", "telugumv", "filmycab", "tellyhd", "filmyfiy", "hindmoviez", "tamilblasters", "hubcloud", "movienestbd", "movies4u", "cinevood", "dudefilms", "fibwatch", "fibtoon", "fibdrama", "xprimehub", "m4ufree", "zinkmovies", "cinefreak", "pencurimoviesubmalay", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMoviesdrive", "()Ljava/lang/String;", "getHdhub4u", "getN4khdhub", "getMultiMovies", "getBollyflix", "getUhdmovies", "getMoviesmod", "getTopMovies", "getHdmovie2", "getVegamovies", "getRogmovies", "getLuxmovies", "getMovierulzhd", "getExtramovies", "getBanglaplex", "getToonstream", "getTelugumv", "getFilmycab", "getTellyhd", "getFilmyfiy", "getHindmoviez", "getTamilblasters", "getHubcloud", "getMovienestbd", "getMovies4u", "getCinevood", "getDudefilms", "getFibwatch", "getFibtoon", "getFibdrama", "getXprimehub", "getM4ufree", "getZinkmovies", "getCinefreak", "getPencurimoviesubmalay", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class DomainsParser {

    @Nullable
    private final String banglaplex;

    @Nullable
    private final String bollyflix;

    @Nullable
    private final String cinefreak;

    @Nullable
    private final String cinevood;

    @Nullable
    private final String dudefilms;

    @Nullable
    private final String extramovies;

    @Nullable
    private final String fibdrama;

    @Nullable
    private final String fibtoon;

    @Nullable
    private final String fibwatch;

    @Nullable
    private final String filmycab;

    @Nullable
    private final String filmyfiy;

    @Nullable
    private final String hdhub4u;

    @Nullable
    private final String hdmovie2;

    @Nullable
    private final String hindmoviez;

    @Nullable
    private final String hubcloud;

    @Nullable
    private final String luxmovies;

    @Nullable
    private final String m4ufree;

    @Nullable
    private final String movienestbd;

    @Nullable
    private final String movierulzhd;

    @Nullable
    private final String movies4u;

    @Nullable
    private final String moviesdrive;

    @Nullable
    private final String moviesmod;

    @Nullable
    private final String multiMovies;

    @Nullable
    private final String n4khdhub;

    @Nullable
    private final String pencurimoviesubmalay;

    @Nullable
    private final String rogmovies;

    @Nullable
    private final String tamilblasters;

    @Nullable
    private final String tellyhd;

    @Nullable
    private final String telugumv;

    @Nullable
    private final String toonstream;

    @Nullable
    private final String topMovies;

    @Nullable
    private final String uhdmovies;

    @Nullable
    private final String vegamovies;

    @Nullable
    private final String xprimehub;

    @Nullable
    private final String zinkmovies;

    public DomainsParser() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 7, null);
    }

    public static /* synthetic */ DomainsParser copy$default(DomainsParser domainsParser, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, String str33, String str34, String str35, int i, int i2, Object obj) {
        String str36;
        String str37;
        String str38 = (i & 1) != 0 ? domainsParser.moviesdrive : str;
        String str39 = (i & 2) != 0 ? domainsParser.hdhub4u : str2;
        String str40 = (i & 4) != 0 ? domainsParser.n4khdhub : str3;
        String str41 = (i & 8) != 0 ? domainsParser.multiMovies : str4;
        String str42 = (i & 16) != 0 ? domainsParser.bollyflix : str5;
        String str43 = (i & 32) != 0 ? domainsParser.uhdmovies : str6;
        String str44 = (i & 64) != 0 ? domainsParser.moviesmod : str7;
        String str45 = (i & 128) != 0 ? domainsParser.topMovies : str8;
        String str46 = (i & 256) != 0 ? domainsParser.hdmovie2 : str9;
        String str47 = (i & 512) != 0 ? domainsParser.vegamovies : str10;
        String str48 = (i & 1024) != 0 ? domainsParser.rogmovies : str11;
        String str49 = (i & 2048) != 0 ? domainsParser.luxmovies : str12;
        String str50 = (i & 4096) != 0 ? domainsParser.movierulzhd : str13;
        String str51 = (i & 8192) != 0 ? domainsParser.extramovies : str14;
        String str52 = str38;
        String str53 = (i & 16384) != 0 ? domainsParser.banglaplex : str15;
        String str54 = (i & 32768) != 0 ? domainsParser.toonstream : str16;
        String str55 = (i & 65536) != 0 ? domainsParser.telugumv : str17;
        String str56 = (i & 131072) != 0 ? domainsParser.filmycab : str18;
        String str57 = (i & 262144) != 0 ? domainsParser.tellyhd : str19;
        String str58 = (i & 524288) != 0 ? domainsParser.filmyfiy : str20;
        String str59 = (i & 1048576) != 0 ? domainsParser.hindmoviez : str21;
        String str60 = (i & 2097152) != 0 ? domainsParser.tamilblasters : str22;
        String str61 = (i & 4194304) != 0 ? domainsParser.hubcloud : str23;
        String str62 = (i & 8388608) != 0 ? domainsParser.movienestbd : str24;
        String str63 = (i & 16777216) != 0 ? domainsParser.movies4u : str25;
        String str64 = (i & 33554432) != 0 ? domainsParser.cinevood : str26;
        String str65 = (i & 67108864) != 0 ? domainsParser.dudefilms : str27;
        String str66 = (i & 134217728) != 0 ? domainsParser.fibwatch : str28;
        String str67 = (i & 268435456) != 0 ? domainsParser.fibtoon : str29;
        String str68 = (i & 536870912) != 0 ? domainsParser.fibdrama : str30;
        String str69 = (i & 1073741824) != 0 ? domainsParser.xprimehub : str31;
        String str70 = (i & Integer.MIN_VALUE) != 0 ? domainsParser.m4ufree : str32;
        String str71 = (i2 & 1) != 0 ? domainsParser.zinkmovies : str33;
        String str72 = (i2 & 2) != 0 ? domainsParser.cinefreak : str34;
        if ((i2 & 4) != 0) {
            str37 = str72;
            str36 = domainsParser.pencurimoviesubmalay;
        } else {
            str36 = str35;
            str37 = str72;
        }
        return domainsParser.copy(str52, str39, str40, str41, str42, str43, str44, str45, str46, str47, str48, str49, str50, str51, str53, str54, str55, str56, str57, str58, str59, str60, str61, str62, str63, str64, str65, str66, str67, str68, str69, str70, str71, str37, str36);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMoviesdrive() {
        return this.moviesdrive;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getVegamovies() {
        return this.vegamovies;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getRogmovies() {
        return this.rogmovies;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getLuxmovies() {
        return this.luxmovies;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getMovierulzhd() {
        return this.movierulzhd;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getExtramovies() {
        return this.extramovies;
    }

    @Nullable
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getBanglaplex() {
        return this.banglaplex;
    }

    @Nullable
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getToonstream() {
        return this.toonstream;
    }

    @Nullable
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getTelugumv() {
        return this.telugumv;
    }

    @Nullable
    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getFilmycab() {
        return this.filmycab;
    }

    @Nullable
    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getTellyhd() {
        return this.tellyhd;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getHdhub4u() {
        return this.hdhub4u;
    }

    @Nullable
    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getFilmyfiy() {
        return this.filmyfiy;
    }

    @Nullable
    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getHindmoviez() {
        return this.hindmoviez;
    }

    @Nullable
    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getTamilblasters() {
        return this.tamilblasters;
    }

    @Nullable
    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getHubcloud() {
        return this.hubcloud;
    }

    @Nullable
    /* JADX INFO: renamed from: component24, reason: from getter */
    public final String getMovienestbd() {
        return this.movienestbd;
    }

    @Nullable
    /* JADX INFO: renamed from: component25, reason: from getter */
    public final String getMovies4u() {
        return this.movies4u;
    }

    @Nullable
    /* JADX INFO: renamed from: component26, reason: from getter */
    public final String getCinevood() {
        return this.cinevood;
    }

    @Nullable
    /* JADX INFO: renamed from: component27, reason: from getter */
    public final String getDudefilms() {
        return this.dudefilms;
    }

    @Nullable
    /* JADX INFO: renamed from: component28, reason: from getter */
    public final String getFibwatch() {
        return this.fibwatch;
    }

    @Nullable
    /* JADX INFO: renamed from: component29, reason: from getter */
    public final String getFibtoon() {
        return this.fibtoon;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getN4khdhub() {
        return this.n4khdhub;
    }

    @Nullable
    /* JADX INFO: renamed from: component30, reason: from getter */
    public final String getFibdrama() {
        return this.fibdrama;
    }

    @Nullable
    /* JADX INFO: renamed from: component31, reason: from getter */
    public final String getXprimehub() {
        return this.xprimehub;
    }

    @Nullable
    /* JADX INFO: renamed from: component32, reason: from getter */
    public final String getM4ufree() {
        return this.m4ufree;
    }

    @Nullable
    /* JADX INFO: renamed from: component33, reason: from getter */
    public final String getZinkmovies() {
        return this.zinkmovies;
    }

    @Nullable
    /* JADX INFO: renamed from: component34, reason: from getter */
    public final String getCinefreak() {
        return this.cinefreak;
    }

    @Nullable
    /* JADX INFO: renamed from: component35, reason: from getter */
    public final String getPencurimoviesubmalay() {
        return this.pencurimoviesubmalay;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMultiMovies() {
        return this.multiMovies;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getBollyflix() {
        return this.bollyflix;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getUhdmovies() {
        return this.uhdmovies;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getMoviesmod() {
        return this.moviesmod;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getTopMovies() {
        return this.topMovies;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getHdmovie2() {
        return this.hdmovie2;
    }

    @NotNull
    public final DomainsParser copy(@Nullable String moviesdrive, @JsonProperty("HDHUB4u") @Nullable String hdhub4u, @JsonProperty("4khdhub") @Nullable String n4khdhub, @JsonProperty("MultiMovies") @Nullable String multiMovies, @Nullable String bollyflix, @JsonProperty("UHDMovies") @Nullable String uhdmovies, @Nullable String moviesmod, @Nullable String topMovies, @Nullable String hdmovie2, @Nullable String vegamovies, @Nullable String rogmovies, @Nullable String luxmovies, @Nullable String movierulzhd, @Nullable String extramovies, @Nullable String banglaplex, @Nullable String toonstream, @Nullable String telugumv, @Nullable String filmycab, @Nullable String tellyhd, @Nullable String filmyfiy, @Nullable String hindmoviez, @Nullable String tamilblasters, @Nullable String hubcloud, @Nullable String movienestbd, @Nullable String movies4u, @Nullable String cinevood, @Nullable String dudefilms, @Nullable String fibwatch, @Nullable String fibtoon, @Nullable String fibdrama, @Nullable String xprimehub, @Nullable String m4ufree, @Nullable String zinkmovies, @Nullable String cinefreak, @Nullable String pencurimoviesubmalay) {
        return new DomainsParser(moviesdrive, hdhub4u, n4khdhub, multiMovies, bollyflix, uhdmovies, moviesmod, topMovies, hdmovie2, vegamovies, rogmovies, luxmovies, movierulzhd, extramovies, banglaplex, toonstream, telugumv, filmycab, tellyhd, filmyfiy, hindmoviez, tamilblasters, hubcloud, movienestbd, movies4u, cinevood, dudefilms, fibwatch, fibtoon, fibdrama, xprimehub, m4ufree, zinkmovies, cinefreak, pencurimoviesubmalay);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DomainsParser)) {
            return false;
        }
        DomainsParser domainsParser = (DomainsParser) other;
        return Intrinsics.areEqual(this.moviesdrive, domainsParser.moviesdrive) && Intrinsics.areEqual(this.hdhub4u, domainsParser.hdhub4u) && Intrinsics.areEqual(this.n4khdhub, domainsParser.n4khdhub) && Intrinsics.areEqual(this.multiMovies, domainsParser.multiMovies) && Intrinsics.areEqual(this.bollyflix, domainsParser.bollyflix) && Intrinsics.areEqual(this.uhdmovies, domainsParser.uhdmovies) && Intrinsics.areEqual(this.moviesmod, domainsParser.moviesmod) && Intrinsics.areEqual(this.topMovies, domainsParser.topMovies) && Intrinsics.areEqual(this.hdmovie2, domainsParser.hdmovie2) && Intrinsics.areEqual(this.vegamovies, domainsParser.vegamovies) && Intrinsics.areEqual(this.rogmovies, domainsParser.rogmovies) && Intrinsics.areEqual(this.luxmovies, domainsParser.luxmovies) && Intrinsics.areEqual(this.movierulzhd, domainsParser.movierulzhd) && Intrinsics.areEqual(this.extramovies, domainsParser.extramovies) && Intrinsics.areEqual(this.banglaplex, domainsParser.banglaplex) && Intrinsics.areEqual(this.toonstream, domainsParser.toonstream) && Intrinsics.areEqual(this.telugumv, domainsParser.telugumv) && Intrinsics.areEqual(this.filmycab, domainsParser.filmycab) && Intrinsics.areEqual(this.tellyhd, domainsParser.tellyhd) && Intrinsics.areEqual(this.filmyfiy, domainsParser.filmyfiy) && Intrinsics.areEqual(this.hindmoviez, domainsParser.hindmoviez) && Intrinsics.areEqual(this.tamilblasters, domainsParser.tamilblasters) && Intrinsics.areEqual(this.hubcloud, domainsParser.hubcloud) && Intrinsics.areEqual(this.movienestbd, domainsParser.movienestbd) && Intrinsics.areEqual(this.movies4u, domainsParser.movies4u) && Intrinsics.areEqual(this.cinevood, domainsParser.cinevood) && Intrinsics.areEqual(this.dudefilms, domainsParser.dudefilms) && Intrinsics.areEqual(this.fibwatch, domainsParser.fibwatch) && Intrinsics.areEqual(this.fibtoon, domainsParser.fibtoon) && Intrinsics.areEqual(this.fibdrama, domainsParser.fibdrama) && Intrinsics.areEqual(this.xprimehub, domainsParser.xprimehub) && Intrinsics.areEqual(this.m4ufree, domainsParser.m4ufree) && Intrinsics.areEqual(this.zinkmovies, domainsParser.zinkmovies) && Intrinsics.areEqual(this.cinefreak, domainsParser.cinefreak) && Intrinsics.areEqual(this.pencurimoviesubmalay, domainsParser.pencurimoviesubmalay);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.moviesdrive == null ? 0 : this.moviesdrive.hashCode()) * 31) + (this.hdhub4u == null ? 0 : this.hdhub4u.hashCode())) * 31) + (this.n4khdhub == null ? 0 : this.n4khdhub.hashCode())) * 31) + (this.multiMovies == null ? 0 : this.multiMovies.hashCode())) * 31) + (this.bollyflix == null ? 0 : this.bollyflix.hashCode())) * 31) + (this.uhdmovies == null ? 0 : this.uhdmovies.hashCode())) * 31) + (this.moviesmod == null ? 0 : this.moviesmod.hashCode())) * 31) + (this.topMovies == null ? 0 : this.topMovies.hashCode())) * 31) + (this.hdmovie2 == null ? 0 : this.hdmovie2.hashCode())) * 31) + (this.vegamovies == null ? 0 : this.vegamovies.hashCode())) * 31) + (this.rogmovies == null ? 0 : this.rogmovies.hashCode())) * 31) + (this.luxmovies == null ? 0 : this.luxmovies.hashCode())) * 31) + (this.movierulzhd == null ? 0 : this.movierulzhd.hashCode())) * 31) + (this.extramovies == null ? 0 : this.extramovies.hashCode())) * 31) + (this.banglaplex == null ? 0 : this.banglaplex.hashCode())) * 31) + (this.toonstream == null ? 0 : this.toonstream.hashCode())) * 31) + (this.telugumv == null ? 0 : this.telugumv.hashCode())) * 31) + (this.filmycab == null ? 0 : this.filmycab.hashCode())) * 31) + (this.tellyhd == null ? 0 : this.tellyhd.hashCode())) * 31) + (this.filmyfiy == null ? 0 : this.filmyfiy.hashCode())) * 31) + (this.hindmoviez == null ? 0 : this.hindmoviez.hashCode())) * 31) + (this.tamilblasters == null ? 0 : this.tamilblasters.hashCode())) * 31) + (this.hubcloud == null ? 0 : this.hubcloud.hashCode())) * 31) + (this.movienestbd == null ? 0 : this.movienestbd.hashCode())) * 31) + (this.movies4u == null ? 0 : this.movies4u.hashCode())) * 31) + (this.cinevood == null ? 0 : this.cinevood.hashCode())) * 31) + (this.dudefilms == null ? 0 : this.dudefilms.hashCode())) * 31) + (this.fibwatch == null ? 0 : this.fibwatch.hashCode())) * 31) + (this.fibtoon == null ? 0 : this.fibtoon.hashCode())) * 31) + (this.fibdrama == null ? 0 : this.fibdrama.hashCode())) * 31) + (this.xprimehub == null ? 0 : this.xprimehub.hashCode())) * 31) + (this.m4ufree == null ? 0 : this.m4ufree.hashCode())) * 31) + (this.zinkmovies == null ? 0 : this.zinkmovies.hashCode())) * 31) + (this.cinefreak == null ? 0 : this.cinefreak.hashCode())) * 31) + (this.pencurimoviesubmalay != null ? this.pencurimoviesubmalay.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DomainsParser(moviesdrive=").append(this.moviesdrive).append(", hdhub4u=").append(this.hdhub4u).append(", n4khdhub=").append(this.n4khdhub).append(", multiMovies=").append(this.multiMovies).append(", bollyflix=").append(this.bollyflix).append(", uhdmovies=").append(this.uhdmovies).append(", moviesmod=").append(this.moviesmod).append(", topMovies=").append(this.topMovies).append(", hdmovie2=").append(this.hdmovie2).append(", vegamovies=").append(this.vegamovies).append(", rogmovies=").append(this.rogmovies).append(", luxmovies=");
        sb.append(this.luxmovies).append(", movierulzhd=").append(this.movierulzhd).append(", extramovies=").append(this.extramovies).append(", banglaplex=").append(this.banglaplex).append(", toonstream=").append(this.toonstream).append(", telugumv=").append(this.telugumv).append(", filmycab=").append(this.filmycab).append(", tellyhd=").append(this.tellyhd).append(", filmyfiy=").append(this.filmyfiy).append(", hindmoviez=").append(this.hindmoviez).append(", tamilblasters=").append(this.tamilblasters).append(", hubcloud=").append(this.hubcloud);
        sb.append(", movienestbd=").append(this.movienestbd).append(", movies4u=").append(this.movies4u).append(", cinevood=").append(this.cinevood).append(", dudefilms=").append(this.dudefilms).append(", fibwatch=").append(this.fibwatch).append(", fibtoon=").append(this.fibtoon).append(", fibdrama=").append(this.fibdrama).append(", xprimehub=").append(this.xprimehub).append(", m4ufree=").append(this.m4ufree).append(", zinkmovies=").append(this.zinkmovies).append(", cinefreak=").append(this.cinefreak).append(", pencurimoviesubmalay=");
        sb.append(this.pencurimoviesubmalay).append(')');
        return sb.toString();
    }

    public DomainsParser(@Nullable String moviesdrive, @JsonProperty("HDHUB4u") @Nullable String hdhub4u, @JsonProperty("4khdhub") @Nullable String n4khdhub, @JsonProperty("MultiMovies") @Nullable String multiMovies, @Nullable String bollyflix, @JsonProperty("UHDMovies") @Nullable String uhdmovies, @Nullable String moviesmod, @Nullable String topMovies, @Nullable String hdmovie2, @Nullable String vegamovies, @Nullable String rogmovies, @Nullable String luxmovies, @Nullable String movierulzhd, @Nullable String extramovies, @Nullable String banglaplex, @Nullable String toonstream, @Nullable String telugumv, @Nullable String filmycab, @Nullable String tellyhd, @Nullable String filmyfiy, @Nullable String hindmoviez, @Nullable String tamilblasters, @Nullable String hubcloud, @Nullable String movienestbd, @Nullable String movies4u, @Nullable String cinevood, @Nullable String dudefilms, @Nullable String fibwatch, @Nullable String fibtoon, @Nullable String fibdrama, @Nullable String xprimehub, @Nullable String m4ufree, @Nullable String zinkmovies, @Nullable String cinefreak, @Nullable String pencurimoviesubmalay) {
        this.moviesdrive = moviesdrive;
        this.hdhub4u = hdhub4u;
        this.n4khdhub = n4khdhub;
        this.multiMovies = multiMovies;
        this.bollyflix = bollyflix;
        this.uhdmovies = uhdmovies;
        this.moviesmod = moviesmod;
        this.topMovies = topMovies;
        this.hdmovie2 = hdmovie2;
        this.vegamovies = vegamovies;
        this.rogmovies = rogmovies;
        this.luxmovies = luxmovies;
        this.movierulzhd = movierulzhd;
        this.extramovies = extramovies;
        this.banglaplex = banglaplex;
        this.toonstream = toonstream;
        this.telugumv = telugumv;
        this.filmycab = filmycab;
        this.tellyhd = tellyhd;
        this.filmyfiy = filmyfiy;
        this.hindmoviez = hindmoviez;
        this.tamilblasters = tamilblasters;
        this.hubcloud = hubcloud;
        this.movienestbd = movienestbd;
        this.movies4u = movies4u;
        this.cinevood = cinevood;
        this.dudefilms = dudefilms;
        this.fibwatch = fibwatch;
        this.fibtoon = fibtoon;
        this.fibdrama = fibdrama;
        this.xprimehub = xprimehub;
        this.m4ufree = m4ufree;
        this.zinkmovies = zinkmovies;
        this.cinefreak = cinefreak;
        this.pencurimoviesubmalay = pencurimoviesubmalay;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DomainsParser(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, String str33, String str34, String str35, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        String str36 = (i & 1) != 0 ? null : str;
        String str37 = (i & 2) != 0 ? null : str2;
        String str38 = (i & 4) != 0 ? null : str3;
        String str39 = (i & 8) != 0 ? null : str4;
        String str40 = (i & 16) != 0 ? null : str5;
        String str41 = (i & 32) != 0 ? null : str6;
        String str42 = (i & 64) != 0 ? null : str7;
        String str43 = (i & 128) != 0 ? null : str8;
        String str44 = (i & 256) != 0 ? null : str9;
        String str45 = (i & 512) != 0 ? null : str10;
        String str46 = (i & 1024) != 0 ? null : str11;
        String str47 = (i & 2048) != 0 ? null : str12;
        String str48 = (i & 4096) != 0 ? null : str13;
        String str49 = (i & 8192) != 0 ? null : str14;
        String str50 = (i & 16384) != 0 ? null : str15;
        this(str36, str37, str38, str39, str40, str41, str42, str43, str44, str45, str46, str47, str48, str49, str50, (i & 32768) != 0 ? null : str16, (i & 65536) != 0 ? null : str17, (i & 131072) != 0 ? null : str18, (i & 262144) != 0 ? null : str19, (i & 524288) != 0 ? null : str20, (i & 1048576) != 0 ? null : str21, (i & 2097152) != 0 ? null : str22, (i & 4194304) != 0 ? null : str23, (i & 8388608) != 0 ? null : str24, (i & 16777216) != 0 ? null : str25, (i & 33554432) != 0 ? null : str26, (i & 67108864) != 0 ? null : str27, (i & 134217728) != 0 ? null : str28, (i & 268435456) != 0 ? null : str29, (i & 536870912) != 0 ? null : str30, (i & 1073741824) != 0 ? null : str31, (i & Integer.MIN_VALUE) != 0 ? null : str32, (i2 & 1) != 0 ? null : str33, (i2 & 2) != 0 ? null : str34, (i2 & 4) != 0 ? null : str35);
    }

    @Nullable
    public final String getMoviesdrive() {
        return this.moviesdrive;
    }

    @Nullable
    public final String getHdhub4u() {
        return this.hdhub4u;
    }

    @Nullable
    public final String getN4khdhub() {
        return this.n4khdhub;
    }

    @Nullable
    public final String getMultiMovies() {
        return this.multiMovies;
    }

    @Nullable
    public final String getBollyflix() {
        return this.bollyflix;
    }

    @Nullable
    public final String getUhdmovies() {
        return this.uhdmovies;
    }

    @Nullable
    public final String getMoviesmod() {
        return this.moviesmod;
    }

    @Nullable
    public final String getTopMovies() {
        return this.topMovies;
    }

    @Nullable
    public final String getHdmovie2() {
        return this.hdmovie2;
    }

    @Nullable
    public final String getVegamovies() {
        return this.vegamovies;
    }

    @Nullable
    public final String getRogmovies() {
        return this.rogmovies;
    }

    @Nullable
    public final String getLuxmovies() {
        return this.luxmovies;
    }

    @Nullable
    public final String getMovierulzhd() {
        return this.movierulzhd;
    }

    @Nullable
    public final String getExtramovies() {
        return this.extramovies;
    }

    @Nullable
    public final String getBanglaplex() {
        return this.banglaplex;
    }

    @Nullable
    public final String getToonstream() {
        return this.toonstream;
    }

    @Nullable
    public final String getTelugumv() {
        return this.telugumv;
    }

    @Nullable
    public final String getFilmycab() {
        return this.filmycab;
    }

    @Nullable
    public final String getTellyhd() {
        return this.tellyhd;
    }

    @Nullable
    public final String getFilmyfiy() {
        return this.filmyfiy;
    }

    @Nullable
    public final String getHindmoviez() {
        return this.hindmoviez;
    }

    @Nullable
    public final String getTamilblasters() {
        return this.tamilblasters;
    }

    @Nullable
    public final String getHubcloud() {
        return this.hubcloud;
    }

    @Nullable
    public final String getMovienestbd() {
        return this.movienestbd;
    }

    @Nullable
    public final String getMovies4u() {
        return this.movies4u;
    }

    @Nullable
    public final String getCinevood() {
        return this.cinevood;
    }

    @Nullable
    public final String getDudefilms() {
        return this.dudefilms;
    }

    @Nullable
    public final String getFibwatch() {
        return this.fibwatch;
    }

    @Nullable
    public final String getFibtoon() {
        return this.fibtoon;
    }

    @Nullable
    public final String getFibdrama() {
        return this.fibdrama;
    }

    @Nullable
    public final String getXprimehub() {
        return this.xprimehub;
    }

    @Nullable
    public final String getM4ufree() {
        return this.m4ufree;
    }

    @Nullable
    public final String getZinkmovies() {
        return this.zinkmovies;
    }

    @Nullable
    public final String getCinefreak() {
        return this.cinefreak;
    }

    @Nullable
    public final String getPencurimoviesubmalay() {
        return this.pencurimoviesubmalay;
    }
}
