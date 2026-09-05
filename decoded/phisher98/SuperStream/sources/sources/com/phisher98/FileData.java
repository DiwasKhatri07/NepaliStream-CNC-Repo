package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SuperStreamParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/SuperStream/classes.dex */
@Metadata(d1 = {"\u0000+\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0003\bÑ\u0001\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BÛ\u0005\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0011\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0006\u0012\b\u00100\u001a\u0004\u0018\u00010\u0011\u0012\b\u00101\u001a\u0004\u0018\u00010\u0006\u0012\b\u00102\u001a\u0004\u0018\u00010\u0006\u0012\b\u00103\u001a\u0004\u0018\u00010\u0006\u0012\b\u00104\u001a\u0004\u0018\u00010\u0011\u0012\b\u00105\u001a\u0004\u0018\u00010\u0011\u0012\b\u00106\u001a\u0004\u0018\u00010\u0011\u0012\b\u00107\u001a\u0004\u0018\u00010\u0011\u0012\b\u00108\u001a\u0004\u0018\u00010\u0011\u0012\b\u00109\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010:\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010;\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010<\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010=\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010>\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010?\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010@\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010A\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010B\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010C\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010D\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010E\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010F\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010G\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010H\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010I\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010J\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010K\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010L\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010M\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\bN\u0010OJ\n\u0010\u0097\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\n\u0010\u009b\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010ZJ\u0011\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010ZJ\u0011\u0010 \u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010ZJ\f\u0010¡\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010¢\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010£\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\u0011\u0010¤\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\u0011\u0010¥\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\u0011\u0010¦\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010ZJ\u0011\u0010§\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\u0011\u0010¨\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\u0011\u0010©\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\u0011\u0010ª\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\f\u0010«\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010¬\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010®\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010¯\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010ZJ\u0011\u0010°\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010ZJ\u0011\u0010±\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010ZJ\u0011\u0010²\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\f\u0010³\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010´\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\f\u0010µ\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010¶\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\u0011\u0010·\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\f\u0010¸\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010¹\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\u0011\u0010º\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\f\u0010»\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010¼\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\u0011\u0010½\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\u0011\u0010¾\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\u0011\u0010¿\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\u0011\u0010À\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\f\u0010Á\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010Â\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\f\u0010Ã\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010Ä\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010Å\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010Æ\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\u0011\u0010Ç\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\u0011\u0010È\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\u0011\u0010É\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\u0011\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\u0011\u0010Ë\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\u0011\u0010Ì\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\u0011\u0010Í\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\f\u0010Î\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010Ï\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\u0011\u0010Ð\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\u0011\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\f\u0010Ò\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010Ó\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010Ô\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010ZJ\f\u0010Õ\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010Ö\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\u0011\u0010×\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010ZJ\u0011\u0010Ø\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\u0011\u0010Ù\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\f\u0010Ú\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010Û\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010`J\f\u0010Ü\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010Ý\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010Þ\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010ß\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jö\u0006\u0010à\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0003\u0010á\u0001J\u0017\u0010â\u0001\u001a\u00030ã\u00012\t\u0010ä\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\u000b\u0010å\u0001\u001a\u00020\u0011HÖ\u0081\u0004J\u000b\u0010æ\u0001\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bR\u0010QR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bU\u0010TR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bV\u0010TR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bW\u0010TR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bX\u0010TR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010[\u001a\u0004\bY\u0010ZR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010[\u001a\u0004\b\\\u0010ZR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010[\u001a\u0004\b]\u0010ZR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b^\u0010TR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b_\u0010TR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010a\u001a\u0004\b\u0010\u0010`R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010a\u001a\u0004\bb\u0010`R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010a\u001a\u0004\b\u0013\u0010`R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010[\u001a\u0004\bc\u0010ZR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010a\u001a\u0004\bd\u0010`R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010a\u001a\u0004\be\u0010`R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010a\u001a\u0004\bf\u0010`R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010a\u001a\u0004\bg\u0010`R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bh\u0010TR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bi\u0010TR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bj\u0010TR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bk\u0010TR\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010[\u001a\u0004\bl\u0010ZR\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010[\u001a\u0004\bm\u0010ZR\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010[\u001a\u0004\bn\u0010ZR\u0015\u0010 \u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010a\u001a\u0004\bo\u0010`R\u0013\u0010!\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bp\u0010TR\u0015\u0010\"\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010a\u001a\u0004\b\"\u0010`R\u0013\u0010#\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bq\u0010TR\u0015\u0010$\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010a\u001a\u0004\br\u0010`R\u0015\u0010%\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010a\u001a\u0004\bs\u0010`R\u0013\u0010&\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bt\u0010TR\u0015\u0010'\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010a\u001a\u0004\bu\u0010`R\u0015\u0010(\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010a\u001a\u0004\bv\u0010`R\u0013\u0010)\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bw\u0010TR\u0015\u0010*\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010a\u001a\u0004\bx\u0010`R\u0015\u0010+\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010a\u001a\u0004\by\u0010`R\u0015\u0010,\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010a\u001a\u0004\b,\u0010`R\u0015\u0010-\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010a\u001a\u0004\bz\u0010`R\u0015\u0010.\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010a\u001a\u0004\b{\u0010`R\u0013\u0010/\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b|\u0010TR\u0015\u00100\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010a\u001a\u0004\b}\u0010`R\u0013\u00101\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b~\u0010TR\u0013\u00102\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010TR\u0014\u00103\u001a\u0004\u0018\u00010\u0006¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010TR\u0016\u00104\u001a\u0004\u0018\u00010\u0011¢\u0006\u000b\n\u0002\u0010a\u001a\u0005\b\u0081\u0001\u0010`R\u0016\u00105\u001a\u0004\u0018\u00010\u0011¢\u0006\u000b\n\u0002\u0010a\u001a\u0005\b\u0082\u0001\u0010`R\u0016\u00106\u001a\u0004\u0018\u00010\u0011¢\u0006\u000b\n\u0002\u0010a\u001a\u0005\b\u0083\u0001\u0010`R\u0016\u00107\u001a\u0004\u0018\u00010\u0011¢\u0006\u000b\n\u0002\u0010a\u001a\u0005\b\u0084\u0001\u0010`R\u0016\u00108\u001a\u0004\u0018\u00010\u0011¢\u0006\u000b\n\u0002\u0010a\u001a\u0005\b\u0085\u0001\u0010`R\u0016\u00109\u001a\u0004\u0018\u00010\u0011¢\u0006\u000b\n\u0002\u0010a\u001a\u0005\b\u0086\u0001\u0010`R\u0016\u0010:\u001a\u0004\u0018\u00010\u0011¢\u0006\u000b\n\u0002\u0010a\u001a\u0005\b\u0087\u0001\u0010`R\u0016\u0010;\u001a\u0004\u0018\u00010\u0011¢\u0006\u000b\n\u0002\u0010a\u001a\u0005\b\u0088\u0001\u0010`R\u0014\u0010<\u001a\u0004\u0018\u00010\u0006¢\u0006\t\n\u0000\u001a\u0005\b\u0089\u0001\u0010TR\u0016\u0010=\u001a\u0004\u0018\u00010\u0011¢\u0006\u000b\n\u0002\u0010a\u001a\u0005\b\u008a\u0001\u0010`R\u0015\u0010>\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010a\u001a\u0004\b>\u0010`R\u0015\u0010?\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010a\u001a\u0004\b?\u0010`R\u0014\u0010@\u001a\u0004\u0018\u00010\u0006¢\u0006\t\n\u0000\u001a\u0005\b\u008b\u0001\u0010TR\u0014\u0010A\u001a\u0004\u0018\u00010\u0006¢\u0006\t\n\u0000\u001a\u0005\b\u008c\u0001\u0010TR\u0016\u0010B\u001a\u0004\u0018\u00010\u0003¢\u0006\u000b\n\u0002\u0010[\u001a\u0005\b\u008d\u0001\u0010ZR\u0014\u0010C\u001a\u0004\u0018\u00010\u0006¢\u0006\t\n\u0000\u001a\u0005\b\u008e\u0001\u0010TR\u0015\u0010D\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010a\u001a\u0004\bD\u0010`R\u0016\u0010E\u001a\u0004\u0018\u00010\u0003¢\u0006\u000b\n\u0002\u0010[\u001a\u0005\b\u008f\u0001\u0010ZR\u0016\u0010F\u001a\u0004\u0018\u00010\u0011¢\u0006\u000b\n\u0002\u0010a\u001a\u0005\b\u0090\u0001\u0010`R\u0015\u0010G\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010a\u001a\u0004\bG\u0010`R\u0014\u0010H\u001a\u0004\u0018\u00010\u0006¢\u0006\t\n\u0000\u001a\u0005\b\u0091\u0001\u0010TR\u0016\u0010I\u001a\u0004\u0018\u00010\u0011¢\u0006\u000b\n\u0002\u0010a\u001a\u0005\b\u0092\u0001\u0010`R\u0014\u0010J\u001a\u0004\u0018\u00010\u0006¢\u0006\t\n\u0000\u001a\u0005\b\u0093\u0001\u0010TR\u0014\u0010K\u001a\u0004\u0018\u00010\u0006¢\u0006\t\n\u0000\u001a\u0005\b\u0094\u0001\u0010TR\u0014\u0010L\u001a\u0004\u0018\u00010\u0006¢\u0006\t\n\u0000\u001a\u0005\b\u0095\u0001\u0010TR\u0014\u0010M\u001a\u0004\u0018\u00010\u0006¢\u0006\t\n\u0000\u001a\u0005\b\u0096\u0001\u0010T¨\u0006ç\u0001"}, d2 = {"Lcom/phisher98/FileData;", "", "fid", "", "uid", "file_size", "", "path", "file_name", "ext", "add_time", "file_create_time", "file_update_time", "parent_id", "update_time", "last_open_time", "is_dir", "", "epub", "is_music_list", "oss_fid", "faststart", "has_video_quality", "total_download", "status", "remark", "old_hash", "hash", "hash_type", "from_uid", "fid_org", "share_id", "invite_permission", "comment_table", "is_delete", "thumb_small", "thumb_small_width", "thumb_small_height", "thumb", "thumb_width", "thumb_height", "thumb_big", "thumb_big_width", "thumb_big_height", "is_custom_thumb", "fix_thumb", "ffmpeg_ing", "quality", "runtime", "ffmpeg_info", "attribute", "data", "ffmpeg_status", "allow_delete", "allow_download", "allow_comment", "hide_location", "hide_email", "allow_copy", "error_video", "third_data", "photos", "is_album", "is_cloud_sync_dir", "ai_tags", "maybe_tags", "ai_tag_last_time", "user_tags", "is_collect", "sub_fid", "read_only", "is_shared", "bind_imdb_id", "top_is_shared", "type", "update_time2", "file_icon", "param2", "<init>", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFid", "()J", "getUid", "getFile_size", "()Ljava/lang/String;", "getPath", "getFile_name", "getExt", "getAdd_time", "getFile_create_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFile_update_time", "getParent_id", "getUpdate_time", "getLast_open_time", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEpub", "getOss_fid", "getFaststart", "getHas_video_quality", "getTotal_download", "getStatus", "getRemark", "getOld_hash", "getHash", "getHash_type", "getFrom_uid", "getFid_org", "getShare_id", "getInvite_permission", "getComment_table", "getThumb_small", "getThumb_small_width", "getThumb_small_height", "getThumb", "getThumb_width", "getThumb_height", "getThumb_big", "getThumb_big_width", "getThumb_big_height", "getFix_thumb", "getFfmpeg_ing", "getQuality", "getRuntime", "getFfmpeg_info", "getAttribute", "getData", "getFfmpeg_status", "getAllow_delete", "getAllow_download", "getAllow_comment", "getHide_location", "getHide_email", "getAllow_copy", "getError_video", "getThird_data", "getPhotos", "getAi_tags", "getMaybe_tags", "getAi_tag_last_time", "getUser_tags", "getSub_fid", "getRead_only", "getBind_imdb_id", "getTop_is_shared", "getType", "getUpdate_time2", "getFile_icon", "getParam2", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "component69", "component70", "component71", "component72", "component73", "copy", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/phisher98/FileData;", "equals", "", "other", "hashCode", "toString", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class FileData {

    @Nullable
    private final String add_time;

    @Nullable
    private final Long ai_tag_last_time;

    @Nullable
    private final String ai_tags;

    @Nullable
    private final Integer allow_comment;

    @Nullable
    private final Integer allow_copy;

    @Nullable
    private final Integer allow_delete;

    @Nullable
    private final Integer allow_download;

    @Nullable
    private final String attribute;

    @Nullable
    private final String bind_imdb_id;

    @Nullable
    private final String comment_table;

    @Nullable
    private final String data;

    @Nullable
    private final Integer epub;

    @Nullable
    private final Integer error_video;

    @Nullable
    private final String ext;

    @Nullable
    private final Integer faststart;

    @Nullable
    private final String ffmpeg_info;

    @Nullable
    private final Integer ffmpeg_ing;

    @Nullable
    private final Integer ffmpeg_status;
    private final long fid;

    @Nullable
    private final Long fid_org;

    @Nullable
    private final Long file_create_time;

    @Nullable
    private final String file_icon;

    @NotNull
    private final String file_name;

    @Nullable
    private final String file_size;

    @Nullable
    private final Long file_update_time;

    @Nullable
    private final Integer fix_thumb;

    @Nullable
    private final Long from_uid;

    @Nullable
    private final Integer has_video_quality;

    @Nullable
    private final String hash;

    @Nullable
    private final String hash_type;

    @Nullable
    private final Integer hide_email;

    @Nullable
    private final Integer hide_location;

    @Nullable
    private final Integer invite_permission;

    @Nullable
    private final Integer is_album;

    @Nullable
    private final Integer is_cloud_sync_dir;

    @Nullable
    private final Integer is_collect;

    @Nullable
    private final Integer is_custom_thumb;

    @Nullable
    private final Integer is_delete;

    @Nullable
    private final Integer is_dir;

    @Nullable
    private final Integer is_music_list;

    @Nullable
    private final Integer is_shared;

    @Nullable
    private final String last_open_time;

    @Nullable
    private final String maybe_tags;

    @Nullable
    private final String old_hash;

    @Nullable
    private final Long oss_fid;

    @Nullable
    private final String param2;

    @Nullable
    private final Long parent_id;

    @Nullable
    private final String path;

    @Nullable
    private final Integer photos;

    @Nullable
    private final String quality;

    @Nullable
    private final Integer read_only;

    @Nullable
    private final String remark;

    @Nullable
    private final Integer runtime;

    @Nullable
    private final Long share_id;

    @Nullable
    private final Integer status;

    @Nullable
    private final Long sub_fid;

    @Nullable
    private final String third_data;

    @Nullable
    private final String thumb;

    @Nullable
    private final String thumb_big;

    @Nullable
    private final Integer thumb_big_height;

    @Nullable
    private final Integer thumb_big_width;

    @Nullable
    private final Integer thumb_height;

    @Nullable
    private final String thumb_small;

    @Nullable
    private final Integer thumb_small_height;

    @Nullable
    private final Integer thumb_small_width;

    @Nullable
    private final Integer thumb_width;

    @Nullable
    private final Integer top_is_shared;

    @Nullable
    private final Integer total_download;

    @Nullable
    private final String type;
    private final long uid;

    @Nullable
    private final String update_time;

    @Nullable
    private final String update_time2;

    @Nullable
    private final String user_tags;

    public static /* synthetic */ FileData copy$default(FileData fileData, long j, long j2, String str, String str2, String str3, String str4, String str5, Long l, Long l2, Long l3, String str6, String str7, Integer num, Integer num2, Integer num3, Long l4, Integer num4, Integer num5, Integer num6, Integer num7, String str8, String str9, String str10, String str11, Long l5, Long l6, Long l7, Integer num8, String str12, Integer num9, String str13, Integer num10, Integer num11, String str14, Integer num12, Integer num13, String str15, Integer num14, Integer num15, Integer num16, Integer num17, Integer num18, String str16, Integer num19, String str17, String str18, String str19, Integer num20, Integer num21, Integer num22, Integer num23, Integer num24, Integer num25, Integer num26, Integer num27, String str20, Integer num28, Integer num29, Integer num30, String str21, String str22, Long l8, String str23, Integer num31, Long l9, Integer num32, Integer num33, String str24, Integer num34, String str25, String str26, String str27, String str28, int i, int i2, int i3, Object obj) {
        long j3 = (i & 1) != 0 ? fileData.fid : j;
        long j4 = (i & 2) != 0 ? fileData.uid : j2;
        String str29 = (i & 4) != 0 ? fileData.file_size : str;
        String str30 = (i & 8) != 0 ? fileData.path : str2;
        String str31 = (i & 16) != 0 ? fileData.file_name : str3;
        String str32 = (i & 32) != 0 ? fileData.ext : str4;
        String str33 = (i & 64) != 0 ? fileData.add_time : str5;
        Long l10 = (i & 128) != 0 ? fileData.file_create_time : l;
        Long l11 = (i & 256) != 0 ? fileData.file_update_time : l2;
        Long l12 = (i & 512) != 0 ? fileData.parent_id : l3;
        long j5 = j3;
        String str34 = (i & 1024) != 0 ? fileData.update_time : str6;
        String str35 = (i & 2048) != 0 ? fileData.last_open_time : str7;
        String str36 = str34;
        Integer num35 = (i & 4096) != 0 ? fileData.is_dir : num;
        Integer num36 = (i & 8192) != 0 ? fileData.epub : num2;
        Integer num37 = (i & 16384) != 0 ? fileData.is_music_list : num3;
        Long l13 = (i & 32768) != 0 ? fileData.oss_fid : l4;
        Integer num38 = (i & 65536) != 0 ? fileData.faststart : num4;
        Integer num39 = (i & 131072) != 0 ? fileData.has_video_quality : num5;
        Integer num40 = (i & 262144) != 0 ? fileData.total_download : num6;
        Integer num41 = (i & 524288) != 0 ? fileData.status : num7;
        String str37 = (i & 1048576) != 0 ? fileData.remark : str8;
        String str38 = (i & 2097152) != 0 ? fileData.old_hash : str9;
        String str39 = (i & 4194304) != 0 ? fileData.hash : str10;
        String str40 = (i & 8388608) != 0 ? fileData.hash_type : str11;
        Long l14 = (i & 16777216) != 0 ? fileData.from_uid : l5;
        Long l15 = (i & 33554432) != 0 ? fileData.fid_org : l6;
        Long l16 = (i & 67108864) != 0 ? fileData.share_id : l7;
        Integer num42 = (i & 134217728) != 0 ? fileData.invite_permission : num8;
        String str41 = (i & 268435456) != 0 ? fileData.comment_table : str12;
        Integer num43 = (i & 536870912) != 0 ? fileData.is_delete : num9;
        String str42 = (i & 1073741824) != 0 ? fileData.thumb_small : str13;
        Integer num44 = (i & Integer.MIN_VALUE) != 0 ? fileData.thumb_small_width : num10;
        Integer num45 = (i2 & 1) != 0 ? fileData.thumb_small_height : num11;
        String str43 = (i2 & 2) != 0 ? fileData.thumb : str14;
        Integer num46 = (i2 & 4) != 0 ? fileData.thumb_width : num12;
        Integer num47 = (i2 & 8) != 0 ? fileData.thumb_height : num13;
        String str44 = (i2 & 16) != 0 ? fileData.thumb_big : str15;
        Integer num48 = (i2 & 32) != 0 ? fileData.thumb_big_width : num14;
        Integer num49 = (i2 & 64) != 0 ? fileData.thumb_big_height : num15;
        Integer num50 = (i2 & 128) != 0 ? fileData.is_custom_thumb : num16;
        Integer num51 = (i2 & 256) != 0 ? fileData.fix_thumb : num17;
        Integer num52 = (i2 & 512) != 0 ? fileData.ffmpeg_ing : num18;
        String str45 = (i2 & 1024) != 0 ? fileData.quality : str16;
        Integer num53 = (i2 & 2048) != 0 ? fileData.runtime : num19;
        String str46 = (i2 & 4096) != 0 ? fileData.ffmpeg_info : str17;
        String str47 = (i2 & 8192) != 0 ? fileData.attribute : str18;
        String str48 = (i2 & 16384) != 0 ? fileData.data : str19;
        Integer num54 = (i2 & 32768) != 0 ? fileData.ffmpeg_status : num20;
        Integer num55 = (i2 & 65536) != 0 ? fileData.allow_delete : num21;
        Integer num56 = (i2 & 131072) != 0 ? fileData.allow_download : num22;
        Integer num57 = (i2 & 262144) != 0 ? fileData.allow_comment : num23;
        Integer num58 = (i2 & 524288) != 0 ? fileData.hide_location : num24;
        Integer num59 = (i2 & 1048576) != 0 ? fileData.hide_email : num25;
        Integer num60 = (i2 & 2097152) != 0 ? fileData.allow_copy : num26;
        Integer num61 = (i2 & 4194304) != 0 ? fileData.error_video : num27;
        String str49 = (i2 & 8388608) != 0 ? fileData.third_data : str20;
        Integer num62 = (i2 & 16777216) != 0 ? fileData.photos : num28;
        Integer num63 = (i2 & 33554432) != 0 ? fileData.is_album : num29;
        Integer num64 = (i2 & 67108864) != 0 ? fileData.is_cloud_sync_dir : num30;
        String str50 = (i2 & 134217728) != 0 ? fileData.ai_tags : str21;
        String str51 = (i2 & 268435456) != 0 ? fileData.maybe_tags : str22;
        Long l17 = (i2 & 536870912) != 0 ? fileData.ai_tag_last_time : l8;
        String str52 = (i2 & 1073741824) != 0 ? fileData.user_tags : str23;
        return fileData.copy(j5, j4, str29, str30, str31, str32, str33, l10, l11, l12, str36, str35, num35, num36, num37, l13, num38, num39, num40, num41, str37, str38, str39, str40, l14, l15, l16, num42, str41, num43, str42, num44, num45, str43, num46, num47, str44, num48, num49, num50, num51, num52, str45, num53, str46, str47, str48, num54, num55, num56, num57, num58, num59, num60, num61, str49, num62, num63, num64, str50, str51, l17, str52, (i2 & Integer.MIN_VALUE) != 0 ? fileData.is_collect : num31, (i3 & 1) != 0 ? fileData.sub_fid : l9, (i3 & 2) != 0 ? fileData.read_only : num32, (i3 & 4) != 0 ? fileData.is_shared : num33, (i3 & 8) != 0 ? fileData.bind_imdb_id : str24, (i3 & 16) != 0 ? fileData.top_is_shared : num34, (i3 & 32) != 0 ? fileData.type : str25, (i3 & 64) != 0 ? fileData.update_time2 : str26, (i3 & 128) != 0 ? fileData.file_icon : str27, (i3 & 256) != 0 ? fileData.param2 : str28);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getFid() {
        return this.fid;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Long getParent_id() {
        return this.parent_id;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getUpdate_time() {
        return this.update_time;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getLast_open_time() {
        return this.last_open_time;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Integer getIs_dir() {
        return this.is_dir;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Integer getEpub() {
        return this.epub;
    }

    @Nullable
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Integer getIs_music_list() {
        return this.is_music_list;
    }

    @Nullable
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Long getOss_fid() {
        return this.oss_fid;
    }

    @Nullable
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Integer getFaststart() {
        return this.faststart;
    }

    @Nullable
    /* JADX INFO: renamed from: component18, reason: from getter */
    public final Integer getHas_video_quality() {
        return this.has_video_quality;
    }

    @Nullable
    /* JADX INFO: renamed from: component19, reason: from getter */
    public final Integer getTotal_download() {
        return this.total_download;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getUid() {
        return this.uid;
    }

    @Nullable
    /* JADX INFO: renamed from: component20, reason: from getter */
    public final Integer getStatus() {
        return this.status;
    }

    @Nullable
    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getRemark() {
        return this.remark;
    }

    @Nullable
    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getOld_hash() {
        return this.old_hash;
    }

    @Nullable
    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getHash() {
        return this.hash;
    }

    @Nullable
    /* JADX INFO: renamed from: component24, reason: from getter */
    public final String getHash_type() {
        return this.hash_type;
    }

    @Nullable
    /* JADX INFO: renamed from: component25, reason: from getter */
    public final Long getFrom_uid() {
        return this.from_uid;
    }

    @Nullable
    /* JADX INFO: renamed from: component26, reason: from getter */
    public final Long getFid_org() {
        return this.fid_org;
    }

    @Nullable
    /* JADX INFO: renamed from: component27, reason: from getter */
    public final Long getShare_id() {
        return this.share_id;
    }

    @Nullable
    /* JADX INFO: renamed from: component28, reason: from getter */
    public final Integer getInvite_permission() {
        return this.invite_permission;
    }

    @Nullable
    /* JADX INFO: renamed from: component29, reason: from getter */
    public final String getComment_table() {
        return this.comment_table;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFile_size() {
        return this.file_size;
    }

    @Nullable
    /* JADX INFO: renamed from: component30, reason: from getter */
    public final Integer getIs_delete() {
        return this.is_delete;
    }

    @Nullable
    /* JADX INFO: renamed from: component31, reason: from getter */
    public final String getThumb_small() {
        return this.thumb_small;
    }

    @Nullable
    /* JADX INFO: renamed from: component32, reason: from getter */
    public final Integer getThumb_small_width() {
        return this.thumb_small_width;
    }

    @Nullable
    /* JADX INFO: renamed from: component33, reason: from getter */
    public final Integer getThumb_small_height() {
        return this.thumb_small_height;
    }

    @Nullable
    /* JADX INFO: renamed from: component34, reason: from getter */
    public final String getThumb() {
        return this.thumb;
    }

    @Nullable
    /* JADX INFO: renamed from: component35, reason: from getter */
    public final Integer getThumb_width() {
        return this.thumb_width;
    }

    @Nullable
    /* JADX INFO: renamed from: component36, reason: from getter */
    public final Integer getThumb_height() {
        return this.thumb_height;
    }

    @Nullable
    /* JADX INFO: renamed from: component37, reason: from getter */
    public final String getThumb_big() {
        return this.thumb_big;
    }

    @Nullable
    /* JADX INFO: renamed from: component38, reason: from getter */
    public final Integer getThumb_big_width() {
        return this.thumb_big_width;
    }

    @Nullable
    /* JADX INFO: renamed from: component39, reason: from getter */
    public final Integer getThumb_big_height() {
        return this.thumb_big_height;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    @Nullable
    /* JADX INFO: renamed from: component40, reason: from getter */
    public final Integer getIs_custom_thumb() {
        return this.is_custom_thumb;
    }

    @Nullable
    /* JADX INFO: renamed from: component41, reason: from getter */
    public final Integer getFix_thumb() {
        return this.fix_thumb;
    }

    @Nullable
    /* JADX INFO: renamed from: component42, reason: from getter */
    public final Integer getFfmpeg_ing() {
        return this.ffmpeg_ing;
    }

    @Nullable
    /* JADX INFO: renamed from: component43, reason: from getter */
    public final String getQuality() {
        return this.quality;
    }

    @Nullable
    /* JADX INFO: renamed from: component44, reason: from getter */
    public final Integer getRuntime() {
        return this.runtime;
    }

    @Nullable
    /* JADX INFO: renamed from: component45, reason: from getter */
    public final String getFfmpeg_info() {
        return this.ffmpeg_info;
    }

    @Nullable
    /* JADX INFO: renamed from: component46, reason: from getter */
    public final String getAttribute() {
        return this.attribute;
    }

    @Nullable
    /* JADX INFO: renamed from: component47, reason: from getter */
    public final String getData() {
        return this.data;
    }

    @Nullable
    /* JADX INFO: renamed from: component48, reason: from getter */
    public final Integer getFfmpeg_status() {
        return this.ffmpeg_status;
    }

    @Nullable
    /* JADX INFO: renamed from: component49, reason: from getter */
    public final Integer getAllow_delete() {
        return this.allow_delete;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getFile_name() {
        return this.file_name;
    }

    @Nullable
    /* JADX INFO: renamed from: component50, reason: from getter */
    public final Integer getAllow_download() {
        return this.allow_download;
    }

    @Nullable
    /* JADX INFO: renamed from: component51, reason: from getter */
    public final Integer getAllow_comment() {
        return this.allow_comment;
    }

    @Nullable
    /* JADX INFO: renamed from: component52, reason: from getter */
    public final Integer getHide_location() {
        return this.hide_location;
    }

    @Nullable
    /* JADX INFO: renamed from: component53, reason: from getter */
    public final Integer getHide_email() {
        return this.hide_email;
    }

    @Nullable
    /* JADX INFO: renamed from: component54, reason: from getter */
    public final Integer getAllow_copy() {
        return this.allow_copy;
    }

    @Nullable
    /* JADX INFO: renamed from: component55, reason: from getter */
    public final Integer getError_video() {
        return this.error_video;
    }

    @Nullable
    /* JADX INFO: renamed from: component56, reason: from getter */
    public final String getThird_data() {
        return this.third_data;
    }

    @Nullable
    /* JADX INFO: renamed from: component57, reason: from getter */
    public final Integer getPhotos() {
        return this.photos;
    }

    @Nullable
    /* JADX INFO: renamed from: component58, reason: from getter */
    public final Integer getIs_album() {
        return this.is_album;
    }

    @Nullable
    /* JADX INFO: renamed from: component59, reason: from getter */
    public final Integer getIs_cloud_sync_dir() {
        return this.is_cloud_sync_dir;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getExt() {
        return this.ext;
    }

    @Nullable
    /* JADX INFO: renamed from: component60, reason: from getter */
    public final String getAi_tags() {
        return this.ai_tags;
    }

    @Nullable
    /* JADX INFO: renamed from: component61, reason: from getter */
    public final String getMaybe_tags() {
        return this.maybe_tags;
    }

    @Nullable
    /* JADX INFO: renamed from: component62, reason: from getter */
    public final Long getAi_tag_last_time() {
        return this.ai_tag_last_time;
    }

    @Nullable
    /* JADX INFO: renamed from: component63, reason: from getter */
    public final String getUser_tags() {
        return this.user_tags;
    }

    @Nullable
    /* JADX INFO: renamed from: component64, reason: from getter */
    public final Integer getIs_collect() {
        return this.is_collect;
    }

    @Nullable
    /* JADX INFO: renamed from: component65, reason: from getter */
    public final Long getSub_fid() {
        return this.sub_fid;
    }

    @Nullable
    /* JADX INFO: renamed from: component66, reason: from getter */
    public final Integer getRead_only() {
        return this.read_only;
    }

    @Nullable
    /* JADX INFO: renamed from: component67, reason: from getter */
    public final Integer getIs_shared() {
        return this.is_shared;
    }

    @Nullable
    /* JADX INFO: renamed from: component68, reason: from getter */
    public final String getBind_imdb_id() {
        return this.bind_imdb_id;
    }

    @Nullable
    /* JADX INFO: renamed from: component69, reason: from getter */
    public final Integer getTop_is_shared() {
        return this.top_is_shared;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getAdd_time() {
        return this.add_time;
    }

    @Nullable
    /* JADX INFO: renamed from: component70, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* JADX INFO: renamed from: component71, reason: from getter */
    public final String getUpdate_time2() {
        return this.update_time2;
    }

    @Nullable
    /* JADX INFO: renamed from: component72, reason: from getter */
    public final String getFile_icon() {
        return this.file_icon;
    }

    @Nullable
    /* JADX INFO: renamed from: component73, reason: from getter */
    public final String getParam2() {
        return this.param2;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Long getFile_create_time() {
        return this.file_create_time;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Long getFile_update_time() {
        return this.file_update_time;
    }

    @NotNull
    public final FileData copy(long fid, long uid, @Nullable String file_size, @Nullable String path, @NotNull String file_name, @Nullable String ext, @Nullable String add_time, @Nullable Long file_create_time, @Nullable Long file_update_time, @Nullable Long parent_id, @Nullable String update_time, @Nullable String last_open_time, @Nullable Integer is_dir, @Nullable Integer epub, @Nullable Integer is_music_list, @Nullable Long oss_fid, @Nullable Integer faststart, @Nullable Integer has_video_quality, @Nullable Integer total_download, @Nullable Integer status, @Nullable String remark, @Nullable String old_hash, @Nullable String hash, @Nullable String hash_type, @Nullable Long from_uid, @Nullable Long fid_org, @Nullable Long share_id, @Nullable Integer invite_permission, @Nullable String comment_table, @Nullable Integer is_delete, @Nullable String thumb_small, @Nullable Integer thumb_small_width, @Nullable Integer thumb_small_height, @Nullable String thumb, @Nullable Integer thumb_width, @Nullable Integer thumb_height, @Nullable String thumb_big, @Nullable Integer thumb_big_width, @Nullable Integer thumb_big_height, @Nullable Integer is_custom_thumb, @Nullable Integer fix_thumb, @Nullable Integer ffmpeg_ing, @Nullable String quality, @Nullable Integer runtime, @Nullable String ffmpeg_info, @Nullable String attribute, @Nullable String data, @Nullable Integer ffmpeg_status, @Nullable Integer allow_delete, @Nullable Integer allow_download, @Nullable Integer allow_comment, @Nullable Integer hide_location, @Nullable Integer hide_email, @Nullable Integer allow_copy, @Nullable Integer error_video, @Nullable String third_data, @Nullable Integer photos, @Nullable Integer is_album, @Nullable Integer is_cloud_sync_dir, @Nullable String ai_tags, @Nullable String maybe_tags, @Nullable Long ai_tag_last_time, @Nullable String user_tags, @Nullable Integer is_collect, @Nullable Long sub_fid, @Nullable Integer read_only, @Nullable Integer is_shared, @Nullable String bind_imdb_id, @Nullable Integer top_is_shared, @Nullable String type, @Nullable String update_time2, @Nullable String file_icon, @Nullable String param2) {
        return new FileData(fid, uid, file_size, path, file_name, ext, add_time, file_create_time, file_update_time, parent_id, update_time, last_open_time, is_dir, epub, is_music_list, oss_fid, faststart, has_video_quality, total_download, status, remark, old_hash, hash, hash_type, from_uid, fid_org, share_id, invite_permission, comment_table, is_delete, thumb_small, thumb_small_width, thumb_small_height, thumb, thumb_width, thumb_height, thumb_big, thumb_big_width, thumb_big_height, is_custom_thumb, fix_thumb, ffmpeg_ing, quality, runtime, ffmpeg_info, attribute, data, ffmpeg_status, allow_delete, allow_download, allow_comment, hide_location, hide_email, allow_copy, error_video, third_data, photos, is_album, is_cloud_sync_dir, ai_tags, maybe_tags, ai_tag_last_time, user_tags, is_collect, sub_fid, read_only, is_shared, bind_imdb_id, top_is_shared, type, update_time2, file_icon, param2);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileData)) {
            return false;
        }
        FileData fileData = (FileData) other;
        return this.fid == fileData.fid && this.uid == fileData.uid && Intrinsics.areEqual(this.file_size, fileData.file_size) && Intrinsics.areEqual(this.path, fileData.path) && Intrinsics.areEqual(this.file_name, fileData.file_name) && Intrinsics.areEqual(this.ext, fileData.ext) && Intrinsics.areEqual(this.add_time, fileData.add_time) && Intrinsics.areEqual(this.file_create_time, fileData.file_create_time) && Intrinsics.areEqual(this.file_update_time, fileData.file_update_time) && Intrinsics.areEqual(this.parent_id, fileData.parent_id) && Intrinsics.areEqual(this.update_time, fileData.update_time) && Intrinsics.areEqual(this.last_open_time, fileData.last_open_time) && Intrinsics.areEqual(this.is_dir, fileData.is_dir) && Intrinsics.areEqual(this.epub, fileData.epub) && Intrinsics.areEqual(this.is_music_list, fileData.is_music_list) && Intrinsics.areEqual(this.oss_fid, fileData.oss_fid) && Intrinsics.areEqual(this.faststart, fileData.faststart) && Intrinsics.areEqual(this.has_video_quality, fileData.has_video_quality) && Intrinsics.areEqual(this.total_download, fileData.total_download) && Intrinsics.areEqual(this.status, fileData.status) && Intrinsics.areEqual(this.remark, fileData.remark) && Intrinsics.areEqual(this.old_hash, fileData.old_hash) && Intrinsics.areEqual(this.hash, fileData.hash) && Intrinsics.areEqual(this.hash_type, fileData.hash_type) && Intrinsics.areEqual(this.from_uid, fileData.from_uid) && Intrinsics.areEqual(this.fid_org, fileData.fid_org) && Intrinsics.areEqual(this.share_id, fileData.share_id) && Intrinsics.areEqual(this.invite_permission, fileData.invite_permission) && Intrinsics.areEqual(this.comment_table, fileData.comment_table) && Intrinsics.areEqual(this.is_delete, fileData.is_delete) && Intrinsics.areEqual(this.thumb_small, fileData.thumb_small) && Intrinsics.areEqual(this.thumb_small_width, fileData.thumb_small_width) && Intrinsics.areEqual(this.thumb_small_height, fileData.thumb_small_height) && Intrinsics.areEqual(this.thumb, fileData.thumb) && Intrinsics.areEqual(this.thumb_width, fileData.thumb_width) && Intrinsics.areEqual(this.thumb_height, fileData.thumb_height) && Intrinsics.areEqual(this.thumb_big, fileData.thumb_big) && Intrinsics.areEqual(this.thumb_big_width, fileData.thumb_big_width) && Intrinsics.areEqual(this.thumb_big_height, fileData.thumb_big_height) && Intrinsics.areEqual(this.is_custom_thumb, fileData.is_custom_thumb) && Intrinsics.areEqual(this.fix_thumb, fileData.fix_thumb) && Intrinsics.areEqual(this.ffmpeg_ing, fileData.ffmpeg_ing) && Intrinsics.areEqual(this.quality, fileData.quality) && Intrinsics.areEqual(this.runtime, fileData.runtime) && Intrinsics.areEqual(this.ffmpeg_info, fileData.ffmpeg_info) && Intrinsics.areEqual(this.attribute, fileData.attribute) && Intrinsics.areEqual(this.data, fileData.data) && Intrinsics.areEqual(this.ffmpeg_status, fileData.ffmpeg_status) && Intrinsics.areEqual(this.allow_delete, fileData.allow_delete) && Intrinsics.areEqual(this.allow_download, fileData.allow_download) && Intrinsics.areEqual(this.allow_comment, fileData.allow_comment) && Intrinsics.areEqual(this.hide_location, fileData.hide_location) && Intrinsics.areEqual(this.hide_email, fileData.hide_email) && Intrinsics.areEqual(this.allow_copy, fileData.allow_copy) && Intrinsics.areEqual(this.error_video, fileData.error_video) && Intrinsics.areEqual(this.third_data, fileData.third_data) && Intrinsics.areEqual(this.photos, fileData.photos) && Intrinsics.areEqual(this.is_album, fileData.is_album) && Intrinsics.areEqual(this.is_cloud_sync_dir, fileData.is_cloud_sync_dir) && Intrinsics.areEqual(this.ai_tags, fileData.ai_tags) && Intrinsics.areEqual(this.maybe_tags, fileData.maybe_tags) && Intrinsics.areEqual(this.ai_tag_last_time, fileData.ai_tag_last_time) && Intrinsics.areEqual(this.user_tags, fileData.user_tags) && Intrinsics.areEqual(this.is_collect, fileData.is_collect) && Intrinsics.areEqual(this.sub_fid, fileData.sub_fid) && Intrinsics.areEqual(this.read_only, fileData.read_only) && Intrinsics.areEqual(this.is_shared, fileData.is_shared) && Intrinsics.areEqual(this.bind_imdb_id, fileData.bind_imdb_id) && Intrinsics.areEqual(this.top_is_shared, fileData.top_is_shared) && Intrinsics.areEqual(this.type, fileData.type) && Intrinsics.areEqual(this.update_time2, fileData.update_time2) && Intrinsics.areEqual(this.file_icon, fileData.file_icon) && Intrinsics.areEqual(this.param2, fileData.param2);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((FileData$$ExternalSyntheticBackport0.m3m(this.fid) * 31) + FileData$$ExternalSyntheticBackport0.m3m(this.uid)) * 31) + (this.file_size == null ? 0 : this.file_size.hashCode())) * 31) + (this.path == null ? 0 : this.path.hashCode())) * 31) + this.file_name.hashCode()) * 31) + (this.ext == null ? 0 : this.ext.hashCode())) * 31) + (this.add_time == null ? 0 : this.add_time.hashCode())) * 31) + (this.file_create_time == null ? 0 : this.file_create_time.hashCode())) * 31) + (this.file_update_time == null ? 0 : this.file_update_time.hashCode())) * 31) + (this.parent_id == null ? 0 : this.parent_id.hashCode())) * 31) + (this.update_time == null ? 0 : this.update_time.hashCode())) * 31) + (this.last_open_time == null ? 0 : this.last_open_time.hashCode())) * 31) + (this.is_dir == null ? 0 : this.is_dir.hashCode())) * 31) + (this.epub == null ? 0 : this.epub.hashCode())) * 31) + (this.is_music_list == null ? 0 : this.is_music_list.hashCode())) * 31) + (this.oss_fid == null ? 0 : this.oss_fid.hashCode())) * 31) + (this.faststart == null ? 0 : this.faststart.hashCode())) * 31) + (this.has_video_quality == null ? 0 : this.has_video_quality.hashCode())) * 31) + (this.total_download == null ? 0 : this.total_download.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.remark == null ? 0 : this.remark.hashCode())) * 31) + (this.old_hash == null ? 0 : this.old_hash.hashCode())) * 31) + (this.hash == null ? 0 : this.hash.hashCode())) * 31) + (this.hash_type == null ? 0 : this.hash_type.hashCode())) * 31) + (this.from_uid == null ? 0 : this.from_uid.hashCode())) * 31) + (this.fid_org == null ? 0 : this.fid_org.hashCode())) * 31) + (this.share_id == null ? 0 : this.share_id.hashCode())) * 31) + (this.invite_permission == null ? 0 : this.invite_permission.hashCode())) * 31) + (this.comment_table == null ? 0 : this.comment_table.hashCode())) * 31) + (this.is_delete == null ? 0 : this.is_delete.hashCode())) * 31) + (this.thumb_small == null ? 0 : this.thumb_small.hashCode())) * 31) + (this.thumb_small_width == null ? 0 : this.thumb_small_width.hashCode())) * 31) + (this.thumb_small_height == null ? 0 : this.thumb_small_height.hashCode())) * 31) + (this.thumb == null ? 0 : this.thumb.hashCode())) * 31) + (this.thumb_width == null ? 0 : this.thumb_width.hashCode())) * 31) + (this.thumb_height == null ? 0 : this.thumb_height.hashCode())) * 31) + (this.thumb_big == null ? 0 : this.thumb_big.hashCode())) * 31) + (this.thumb_big_width == null ? 0 : this.thumb_big_width.hashCode())) * 31) + (this.thumb_big_height == null ? 0 : this.thumb_big_height.hashCode())) * 31) + (this.is_custom_thumb == null ? 0 : this.is_custom_thumb.hashCode())) * 31) + (this.fix_thumb == null ? 0 : this.fix_thumb.hashCode())) * 31) + (this.ffmpeg_ing == null ? 0 : this.ffmpeg_ing.hashCode())) * 31) + (this.quality == null ? 0 : this.quality.hashCode())) * 31) + (this.runtime == null ? 0 : this.runtime.hashCode())) * 31) + (this.ffmpeg_info == null ? 0 : this.ffmpeg_info.hashCode())) * 31) + (this.attribute == null ? 0 : this.attribute.hashCode())) * 31) + (this.data == null ? 0 : this.data.hashCode())) * 31) + (this.ffmpeg_status == null ? 0 : this.ffmpeg_status.hashCode())) * 31) + (this.allow_delete == null ? 0 : this.allow_delete.hashCode())) * 31) + (this.allow_download == null ? 0 : this.allow_download.hashCode())) * 31) + (this.allow_comment == null ? 0 : this.allow_comment.hashCode())) * 31) + (this.hide_location == null ? 0 : this.hide_location.hashCode())) * 31) + (this.hide_email == null ? 0 : this.hide_email.hashCode())) * 31) + (this.allow_copy == null ? 0 : this.allow_copy.hashCode())) * 31) + (this.error_video == null ? 0 : this.error_video.hashCode())) * 31) + (this.third_data == null ? 0 : this.third_data.hashCode())) * 31) + (this.photos == null ? 0 : this.photos.hashCode())) * 31) + (this.is_album == null ? 0 : this.is_album.hashCode())) * 31) + (this.is_cloud_sync_dir == null ? 0 : this.is_cloud_sync_dir.hashCode())) * 31) + (this.ai_tags == null ? 0 : this.ai_tags.hashCode())) * 31) + (this.maybe_tags == null ? 0 : this.maybe_tags.hashCode())) * 31) + (this.ai_tag_last_time == null ? 0 : this.ai_tag_last_time.hashCode())) * 31) + (this.user_tags == null ? 0 : this.user_tags.hashCode())) * 31) + (this.is_collect == null ? 0 : this.is_collect.hashCode())) * 31) + (this.sub_fid == null ? 0 : this.sub_fid.hashCode())) * 31) + (this.read_only == null ? 0 : this.read_only.hashCode())) * 31) + (this.is_shared == null ? 0 : this.is_shared.hashCode())) * 31) + (this.bind_imdb_id == null ? 0 : this.bind_imdb_id.hashCode())) * 31) + (this.top_is_shared == null ? 0 : this.top_is_shared.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.update_time2 == null ? 0 : this.update_time2.hashCode())) * 31) + (this.file_icon == null ? 0 : this.file_icon.hashCode())) * 31) + (this.param2 != null ? this.param2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FileData(fid=").append(this.fid).append(", uid=").append(this.uid).append(", file_size=").append(this.file_size).append(", path=").append(this.path).append(", file_name=").append(this.file_name).append(", ext=").append(this.ext).append(", add_time=").append(this.add_time).append(", file_create_time=").append(this.file_create_time).append(", file_update_time=").append(this.file_update_time).append(", parent_id=").append(this.parent_id).append(", update_time=").append(this.update_time).append(", last_open_time=");
        sb.append(this.last_open_time).append(", is_dir=").append(this.is_dir).append(", epub=").append(this.epub).append(", is_music_list=").append(this.is_music_list).append(", oss_fid=").append(this.oss_fid).append(", faststart=").append(this.faststart).append(", has_video_quality=").append(this.has_video_quality).append(", total_download=").append(this.total_download).append(", status=").append(this.status).append(", remark=").append(this.remark).append(", old_hash=").append(this.old_hash).append(", hash=").append(this.hash);
        sb.append(", hash_type=").append(this.hash_type).append(", from_uid=").append(this.from_uid).append(", fid_org=").append(this.fid_org).append(", share_id=").append(this.share_id).append(", invite_permission=").append(this.invite_permission).append(", comment_table=").append(this.comment_table).append(", is_delete=").append(this.is_delete).append(", thumb_small=").append(this.thumb_small).append(", thumb_small_width=").append(this.thumb_small_width).append(", thumb_small_height=").append(this.thumb_small_height).append(", thumb=").append(this.thumb).append(", thumb_width=");
        sb.append(this.thumb_width).append(", thumb_height=").append(this.thumb_height).append(", thumb_big=").append(this.thumb_big).append(", thumb_big_width=").append(this.thumb_big_width).append(", thumb_big_height=").append(this.thumb_big_height).append(", is_custom_thumb=").append(this.is_custom_thumb).append(", fix_thumb=").append(this.fix_thumb).append(", ffmpeg_ing=").append(this.ffmpeg_ing).append(", quality=").append(this.quality).append(", runtime=").append(this.runtime).append(", ffmpeg_info=").append(this.ffmpeg_info).append(", attribute=").append(this.attribute);
        sb.append(", data=").append(this.data).append(", ffmpeg_status=").append(this.ffmpeg_status).append(", allow_delete=").append(this.allow_delete).append(", allow_download=").append(this.allow_download).append(", allow_comment=").append(this.allow_comment).append(", hide_location=").append(this.hide_location).append(", hide_email=").append(this.hide_email).append(", allow_copy=").append(this.allow_copy).append(", error_video=").append(this.error_video).append(", third_data=").append(this.third_data).append(", photos=").append(this.photos).append(", is_album=");
        sb.append(this.is_album).append(", is_cloud_sync_dir=").append(this.is_cloud_sync_dir).append(", ai_tags=").append(this.ai_tags).append(", maybe_tags=").append(this.maybe_tags).append(", ai_tag_last_time=").append(this.ai_tag_last_time).append(", user_tags=").append(this.user_tags).append(", is_collect=").append(this.is_collect).append(", sub_fid=").append(this.sub_fid).append(", read_only=").append(this.read_only).append(", is_shared=").append(this.is_shared).append(", bind_imdb_id=").append(this.bind_imdb_id).append(", top_is_shared=").append(this.top_is_shared);
        sb.append(", type=").append(this.type).append(", update_time2=").append(this.update_time2).append(", file_icon=").append(this.file_icon).append(", param2=").append(this.param2).append(')');
        return sb.toString();
    }

    public FileData(long fid, long uid, @Nullable String file_size, @Nullable String path, @NotNull String file_name, @Nullable String ext, @Nullable String add_time, @Nullable Long file_create_time, @Nullable Long file_update_time, @Nullable Long parent_id, @Nullable String update_time, @Nullable String last_open_time, @Nullable Integer is_dir, @Nullable Integer epub, @Nullable Integer is_music_list, @Nullable Long oss_fid, @Nullable Integer faststart, @Nullable Integer has_video_quality, @Nullable Integer total_download, @Nullable Integer status, @Nullable String remark, @Nullable String old_hash, @Nullable String hash, @Nullable String hash_type, @Nullable Long from_uid, @Nullable Long fid_org, @Nullable Long share_id, @Nullable Integer invite_permission, @Nullable String comment_table, @Nullable Integer is_delete, @Nullable String thumb_small, @Nullable Integer thumb_small_width, @Nullable Integer thumb_small_height, @Nullable String thumb, @Nullable Integer thumb_width, @Nullable Integer thumb_height, @Nullable String thumb_big, @Nullable Integer thumb_big_width, @Nullable Integer thumb_big_height, @Nullable Integer is_custom_thumb, @Nullable Integer fix_thumb, @Nullable Integer ffmpeg_ing, @Nullable String quality, @Nullable Integer runtime, @Nullable String ffmpeg_info, @Nullable String attribute, @Nullable String data, @Nullable Integer ffmpeg_status, @Nullable Integer allow_delete, @Nullable Integer allow_download, @Nullable Integer allow_comment, @Nullable Integer hide_location, @Nullable Integer hide_email, @Nullable Integer allow_copy, @Nullable Integer error_video, @Nullable String third_data, @Nullable Integer photos, @Nullable Integer is_album, @Nullable Integer is_cloud_sync_dir, @Nullable String ai_tags, @Nullable String maybe_tags, @Nullable Long ai_tag_last_time, @Nullable String user_tags, @Nullable Integer is_collect, @Nullable Long sub_fid, @Nullable Integer read_only, @Nullable Integer is_shared, @Nullable String bind_imdb_id, @Nullable Integer top_is_shared, @Nullable String type, @Nullable String update_time2, @Nullable String file_icon, @Nullable String param2) {
        this.fid = fid;
        this.uid = uid;
        this.file_size = file_size;
        this.path = path;
        this.file_name = file_name;
        this.ext = ext;
        this.add_time = add_time;
        this.file_create_time = file_create_time;
        this.file_update_time = file_update_time;
        this.parent_id = parent_id;
        this.update_time = update_time;
        this.last_open_time = last_open_time;
        this.is_dir = is_dir;
        this.epub = epub;
        this.is_music_list = is_music_list;
        this.oss_fid = oss_fid;
        this.faststart = faststart;
        this.has_video_quality = has_video_quality;
        this.total_download = total_download;
        this.status = status;
        this.remark = remark;
        this.old_hash = old_hash;
        this.hash = hash;
        this.hash_type = hash_type;
        this.from_uid = from_uid;
        this.fid_org = fid_org;
        this.share_id = share_id;
        this.invite_permission = invite_permission;
        this.comment_table = comment_table;
        this.is_delete = is_delete;
        this.thumb_small = thumb_small;
        this.thumb_small_width = thumb_small_width;
        this.thumb_small_height = thumb_small_height;
        this.thumb = thumb;
        this.thumb_width = thumb_width;
        this.thumb_height = thumb_height;
        this.thumb_big = thumb_big;
        this.thumb_big_width = thumb_big_width;
        this.thumb_big_height = thumb_big_height;
        this.is_custom_thumb = is_custom_thumb;
        this.fix_thumb = fix_thumb;
        this.ffmpeg_ing = ffmpeg_ing;
        this.quality = quality;
        this.runtime = runtime;
        this.ffmpeg_info = ffmpeg_info;
        this.attribute = attribute;
        this.data = data;
        this.ffmpeg_status = ffmpeg_status;
        this.allow_delete = allow_delete;
        this.allow_download = allow_download;
        this.allow_comment = allow_comment;
        this.hide_location = hide_location;
        this.hide_email = hide_email;
        this.allow_copy = allow_copy;
        this.error_video = error_video;
        this.third_data = third_data;
        this.photos = photos;
        this.is_album = is_album;
        this.is_cloud_sync_dir = is_cloud_sync_dir;
        this.ai_tags = ai_tags;
        this.maybe_tags = maybe_tags;
        this.ai_tag_last_time = ai_tag_last_time;
        this.user_tags = user_tags;
        this.is_collect = is_collect;
        this.sub_fid = sub_fid;
        this.read_only = read_only;
        this.is_shared = is_shared;
        this.bind_imdb_id = bind_imdb_id;
        this.top_is_shared = top_is_shared;
        this.type = type;
        this.update_time2 = update_time2;
        this.file_icon = file_icon;
        this.param2 = param2;
    }

    public final long getFid() {
        return this.fid;
    }

    public final long getUid() {
        return this.uid;
    }

    @Nullable
    public final String getFile_size() {
        return this.file_size;
    }

    @Nullable
    public final String getPath() {
        return this.path;
    }

    @NotNull
    public final String getFile_name() {
        return this.file_name;
    }

    @Nullable
    public final String getExt() {
        return this.ext;
    }

    @Nullable
    public final String getAdd_time() {
        return this.add_time;
    }

    @Nullable
    public final Long getFile_create_time() {
        return this.file_create_time;
    }

    @Nullable
    public final Long getFile_update_time() {
        return this.file_update_time;
    }

    @Nullable
    public final Long getParent_id() {
        return this.parent_id;
    }

    @Nullable
    public final String getUpdate_time() {
        return this.update_time;
    }

    @Nullable
    public final String getLast_open_time() {
        return this.last_open_time;
    }

    @Nullable
    public final Integer is_dir() {
        return this.is_dir;
    }

    @Nullable
    public final Integer getEpub() {
        return this.epub;
    }

    @Nullable
    public final Integer is_music_list() {
        return this.is_music_list;
    }

    @Nullable
    public final Long getOss_fid() {
        return this.oss_fid;
    }

    @Nullable
    public final Integer getFaststart() {
        return this.faststart;
    }

    @Nullable
    public final Integer getHas_video_quality() {
        return this.has_video_quality;
    }

    @Nullable
    public final Integer getTotal_download() {
        return this.total_download;
    }

    @Nullable
    public final Integer getStatus() {
        return this.status;
    }

    @Nullable
    public final String getRemark() {
        return this.remark;
    }

    @Nullable
    public final String getOld_hash() {
        return this.old_hash;
    }

    @Nullable
    public final String getHash() {
        return this.hash;
    }

    @Nullable
    public final String getHash_type() {
        return this.hash_type;
    }

    @Nullable
    public final Long getFrom_uid() {
        return this.from_uid;
    }

    @Nullable
    public final Long getFid_org() {
        return this.fid_org;
    }

    @Nullable
    public final Long getShare_id() {
        return this.share_id;
    }

    @Nullable
    public final Integer getInvite_permission() {
        return this.invite_permission;
    }

    @Nullable
    public final String getComment_table() {
        return this.comment_table;
    }

    @Nullable
    public final Integer is_delete() {
        return this.is_delete;
    }

    @Nullable
    public final String getThumb_small() {
        return this.thumb_small;
    }

    @Nullable
    public final Integer getThumb_small_width() {
        return this.thumb_small_width;
    }

    @Nullable
    public final Integer getThumb_small_height() {
        return this.thumb_small_height;
    }

    @Nullable
    public final String getThumb() {
        return this.thumb;
    }

    @Nullable
    public final Integer getThumb_width() {
        return this.thumb_width;
    }

    @Nullable
    public final Integer getThumb_height() {
        return this.thumb_height;
    }

    @Nullable
    public final String getThumb_big() {
        return this.thumb_big;
    }

    @Nullable
    public final Integer getThumb_big_width() {
        return this.thumb_big_width;
    }

    @Nullable
    public final Integer getThumb_big_height() {
        return this.thumb_big_height;
    }

    @Nullable
    public final Integer is_custom_thumb() {
        return this.is_custom_thumb;
    }

    @Nullable
    public final Integer getFix_thumb() {
        return this.fix_thumb;
    }

    @Nullable
    public final Integer getFfmpeg_ing() {
        return this.ffmpeg_ing;
    }

    @Nullable
    public final String getQuality() {
        return this.quality;
    }

    @Nullable
    public final Integer getRuntime() {
        return this.runtime;
    }

    @Nullable
    public final String getFfmpeg_info() {
        return this.ffmpeg_info;
    }

    @Nullable
    public final String getAttribute() {
        return this.attribute;
    }

    @Nullable
    public final String getData() {
        return this.data;
    }

    @Nullable
    public final Integer getFfmpeg_status() {
        return this.ffmpeg_status;
    }

    @Nullable
    public final Integer getAllow_delete() {
        return this.allow_delete;
    }

    @Nullable
    public final Integer getAllow_download() {
        return this.allow_download;
    }

    @Nullable
    public final Integer getAllow_comment() {
        return this.allow_comment;
    }

    @Nullable
    public final Integer getHide_location() {
        return this.hide_location;
    }

    @Nullable
    public final Integer getHide_email() {
        return this.hide_email;
    }

    @Nullable
    public final Integer getAllow_copy() {
        return this.allow_copy;
    }

    @Nullable
    public final Integer getError_video() {
        return this.error_video;
    }

    @Nullable
    public final String getThird_data() {
        return this.third_data;
    }

    @Nullable
    public final Integer getPhotos() {
        return this.photos;
    }

    @Nullable
    public final Integer is_album() {
        return this.is_album;
    }

    @Nullable
    public final Integer is_cloud_sync_dir() {
        return this.is_cloud_sync_dir;
    }

    @Nullable
    public final String getAi_tags() {
        return this.ai_tags;
    }

    @Nullable
    public final String getMaybe_tags() {
        return this.maybe_tags;
    }

    @Nullable
    public final Long getAi_tag_last_time() {
        return this.ai_tag_last_time;
    }

    @Nullable
    public final String getUser_tags() {
        return this.user_tags;
    }

    @Nullable
    public final Integer is_collect() {
        return this.is_collect;
    }

    @Nullable
    public final Long getSub_fid() {
        return this.sub_fid;
    }

    @Nullable
    public final Integer getRead_only() {
        return this.read_only;
    }

    @Nullable
    public final Integer is_shared() {
        return this.is_shared;
    }

    @Nullable
    public final String getBind_imdb_id() {
        return this.bind_imdb_id;
    }

    @Nullable
    public final Integer getTop_is_shared() {
        return this.top_is_shared;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getUpdate_time2() {
        return this.update_time2;
    }

    @Nullable
    public final String getFile_icon() {
        return this.file_icon;
    }

    @Nullable
    public final String getParam2() {
        return this.param2;
    }
}
